# retrofit-firebase-push
Use Retrofit2 and Firebase Push Notification

# Demo

![20180320_145312](https://user-images.githubusercontent.com/26750131/37657701-1bdb279a-2c22-11e8-95ed-479f43936a41.gif)


# use Retrofit
Retrofit library is created by Square Open Source, it’s a REST client for android and java. By the use of this library, it is easy to request web services of REST with GET, POST, PUT and much more.

[for use](http://square.github.io/retrofit/)

I use my Api Rest ... but I get The idea from this [Api](https://simplifiedcoding.net/demos/marvel/) ***it is sample***

# use Firebase Cloud Messaging


Firebase Cloud Messaging (FCM) is a cross-platform messaging solution that lets you reliably deliver messages at no cost.

In order to establish connection with Firebase, you need to create a project for your own app in the Firebase console. You must set up your project in such a way that every time a user installs it, their device is registered in Firebase with a unique token. Although this may seem complex, the setup is actually simple


# Steps

1- first create your account in [Firebase](https://firebase.google.com/)

2- after that create new project in firebase site

3- and Selection ***Add Firebase to your Android app***

4- fill 3 Frame 
a) "Android Package name" with your application package name in android studio
b) "App nickname" with name you want 
c) "Debug signing certificate SHA-1 (optional)" [with this](https://stackoverflow.com/questions/27609442/how-to-get-the-sha-1-fingerprint-certificate-in-android-studio-for-debug-mode)

5- next step download "google=ervice.json" and add that to your project. and add this plugin and classpath ,... too (https://stackoverflow.com/questions/32072568/how-to-add-google-services-json-in-android)

6- and use the code in classe and update your manifest file too.

7- The last step , go to your account in firebase and select the "Notifications" and "New message" and send message to your users...

good luck؛)
