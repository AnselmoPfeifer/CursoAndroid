Curso Android na High Tech 2015
========
Projetos criados durante o curso de Android 
	
	Libraries for developers
	https://play.google.com/store/apps/details?id=com.desarrollodroide.repos

#Para trabalhar com google maps
	Add em app/build.gradle - compile 'com.google.android.gms:play-services-maps:7.5.0'

	Add logo apos a primeira linha do AndroidManifest
		<!--For Google Maps -->
		<uses-permission android:name="android.permission.INTERNET"/>
		<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
		<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>	
		<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION"/>
		<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>
		<uses-feature 
		android:glEsVersion="0x00020000"
		android:required="true" />
		<!--End For Google Maps -->
	Add antes de fechar  </application>

		<!--For Google Maps -->
		<meta-data
		android:name="com.google.android.gms.version"
		android:value="@integer/google_play_services_version" />
		<meta-data
		android:name="com.google.android.geo.API_KEY"
		android:value="AIzaSyAn46FjkvDdeqO243TXFekKRuB9i5GYclg"/>
		<!--End For Google Maps -->

	Para gerar a API_KEY
	Linux / Mac OS :
	keytool -list -v -keystore ~/.android/debug.keystore -alias androiddebugkey -storepass android -keypass android

	Windows:
	keytool -list -v -keystore "%USERPROFILE%\.android\debug.keystore" -alias androiddebugkey -storepass android -keypass android

	https://console.developers.google.com//flows/enableapi?apiid=maps_android_backend&keyType=CLIENT_SIDE_ANDROID