package com.developtech.consumer_app;



import retrofit.ErrorHandler;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.RestAdapter.LogLevel;



public class RestClient {

	public APIs getClient(String url) {
		RestAdapter restAdapter = new RestAdapter.Builder()
				.setRequestInterceptor(new SessionRequestInterceptor())
				.setEndpoint(url).setLogLevel(LogLevel.FULL).build();
		APIs client = restAdapter.create(APIs.class);
		return client;
	}

	public class SessionRequestInterceptor implements RequestInterceptor {
		private final String TAG = SessionRequestInterceptor.class
				.getSimpleName();

		@Override
		public void intercept(RequestFacade request) {
			request.addHeader("Content-Type", "text/plain");
		}
	}
}
