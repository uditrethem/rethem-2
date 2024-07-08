package calendar;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;

import com.google.api.client.auth.oauth2.Credential;

//import com.google.api.client.auth.oauth2.CredentialStore;
//import com.google.api.client.auth.oauth2.CredentialStoreRefreshListener;
//import com.google.api.client.auth.oauth2.FileCredentialStore;

import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
//import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
//import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
//import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.gson.GsonFactory;
//import com.google.api.client.json.jackson2.JacksonFactory;
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
import java.util.TimeZone;

public class GoogleCalendarExample {
	private static final String APPLICATION_NAME = "rethem";
	private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
	private static final String TOKENS_DIRECTORY_PATH = "tokens";

	public static void main(String[] args) throws Exception {
		// Set up the Calendar service
		Calendar service = initializeCalendar();

		// Example: Create a new event
		Event event = new Event().setSummary("rethem event").setDescription("Addded for test url");

		// Set start and end times
		DateTime startDateTime = new DateTime("2023-11-19T10:00:00.000+05:30"); // Set the time and adjust for the time
																				// zone offset
		EventDateTime start = new EventDateTime().setDateTime(startDateTime).setTimeZone("Asia/Kolkata"); // Set the
																											// time zone
																											// to "IST"
		event.setStart(start);
		/*
		 * // Set start time to the current date and time DateTime startDateTime = new
		 * DateTime(currentDate, TimeZone.getTimeZone("Asia/Kolkata")); EventDateTime
		 * start = new EventDateTime().setDateTime(startDateTime);
		 * event.setStart(start);
		 */

		DateTime endDateTime = new DateTime("2023-11-19T11:00:00.000+05:30");
		EventDateTime end = new EventDateTime().setDateTime(endDateTime).setTimeZone("Asia/Kolkata");
		event.setEnd(end);

		// Add participants (attendees)
		event.setAttendees(Arrays.asList(new EventAttendee().setEmail("participant1@example.com"),
				new EventAttendee().setEmail("participant2@example.com")
		// Add more participants as needed
		));

		// Insert the event
		service.events().insert("primary", event).execute();
	}

	private static Calendar initializeCalendar() throws Exception {
		HttpTransport httpTransport = new NetHttpTransport();
		Credential credential = authorize(httpTransport);
		return new Calendar.Builder(httpTransport, JSON_FACTORY, credential).setApplicationName(APPLICATION_NAME)
				.build();
	}

	private static Credential authorize(HttpTransport httpTransport) throws Exception {
		// Load client secrets
		GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY,
				new FileReader("C:/Users/parik/eclipse-workspace/Rethem/client_secret.json"));

		// Set up authorization code flow
		AuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(httpTransport, JSON_FACTORY, clientSecrets,
				Collections.singleton(CalendarScopes.CALENDAR))
				.setDataStoreFactory(new FileDataStoreFactory(new File(TOKENS_DIRECTORY_PATH))).setAccessType("offline")
				.build();

		// Authorize

		// return new AuthorizationCodeInstalledApp(flow, new
		// LocalServerReceiver()).authorize("user");

		return new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver.Builder() // this code open the browser
																							// to validate
				.setPort(9999) // Change the port if needed
				.build()).authorize("user");

	}
}
