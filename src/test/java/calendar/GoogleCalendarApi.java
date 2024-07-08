package calendar;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventAttendee;
import com.google.api.services.calendar.model.EventDateTime;

import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

public class GoogleCalendarApi {

	private static final String APPLICATION_NAME = "rethem";
	private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
	private static final String TOKENS_DIRECTORY_PATH = "tokens";

	public static void main(String[] args) throws Exception {
		// Set up the Calendar service
		Calendar service = initializeCalendar();

		// Example: Create a new event
		Event event = new Event().setSummary("Automation test").setDescription("https://us02web.zoom.us/j/7461041840");

		// Set start and end times to the current date and time
		Date currentDate = new Date();
		java.util.Calendar calendar = java.util.Calendar.getInstance();
		calendar.setTime(currentDate);
		calendar.add(java.util.Calendar.HOUR_OF_DAY, 1);
		Date startDateTime = calendar.getTime();
		EventDateTime start = new EventDateTime().setDateTime(new DateTime(startDateTime)).setTimeZone("Asia/Kolkata");
		event.setStart(start);

		// Set end time to one hour later
		calendar.add(java.util.Calendar.HOUR_OF_DAY, 1);
		Date endDateTime = calendar.getTime();
		EventDateTime end = new EventDateTime().setDateTime(new DateTime(endDateTime)).setTimeZone("Asia/Kolkata");
		event.setEnd(end);

		// Add participants (attendees)
		event.setAttendees(Arrays.asList(new EventAttendee().setEmail("automation@ymail.com")
		// new EventAttendee().setEmail("ai123@ymail.com")
		// Add more participants as needed
		));

		// Insert the event
		service.events().insert("primary", event).execute();
	}

	private static Calendar initializeCalendar() throws Exception {
		HttpTransport httpTransport = new NetHttpTransport();
		Credential credential = authorize(httpTransport);
		return new com.google.api.services.calendar.Calendar.Builder(httpTransport, JSON_FACTORY, credential)
				.setApplicationName(APPLICATION_NAME).build();
	}

	private static Credential authorize(HttpTransport httpTransport) throws Exception {
		// Load client secrets
		

		String currentDirectory = System.getProperty("user.dir");
		String jsonfilepath = "\\\\client_secret.json";
		File src = new File(currentDirectory + jsonfilepath);
		GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY,
				new FileReader(src));
				//new FileReader("C:/Users/parik/eclipse-workspace/Rethem/client_secret.json"));

		// Set up authorization code flow
		AuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(httpTransport, JSON_FACTORY, clientSecrets,
				Collections.singleton(CalendarScopes.CALENDAR))
				.setDataStoreFactory(new FileDataStoreFactory(new File(TOKENS_DIRECTORY_PATH))).setAccessType("offline")
				.build();

		// Authorize
		return new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver.Builder().setPort(9999).build())
				.authorize("user");
	}
}
