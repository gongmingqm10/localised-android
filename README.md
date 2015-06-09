#Localise Android
This is the spike demo aiming at the localisation work on Android platfrom. Generally speaking, the localisation means distribute your English version application to Chinese Android market, such as Wandoujia, Anzhi and Baidu assistant.

Localisation work not only includes the string localise, but also the service localise. The overseas App uses lots of Google service, such as Google analytics, Google cloud messaging, Google plus login etc. Google service is easy to use on Android plaftofrm, however most of Google services are blocked by China Great Wall.

## Localisation list
* Google Map
* Google plus login
* Google cloud messaging
* Google analytics
* Some English text strings

Based on the above localisation list, we should find the alternative solution to make it available and accessible in China.

| English                                          | Chinese                                 | 
| ------------                                     | -------------                           | 
|[Google Map](https://developers.google.com/maps/)|[GaoDe Map](http://lbs.amap.com/)| 
|[Google Plus](https://developers.google.com/+/api/?hl=zh-cn) | [Umeng Social](http://www.umeng.com/social)  |
|[Google Cloud Messaging](https://developers.google.com/cloud-messaging/)|[Baidu Cloud Push](http://developer.baidu.com/cloud/push)|
|[Google Analytics](https://www.google.com/analytics/)|[Umeng Analytics](http://www.umeng.com/analytics)|


##Solution
Build two versions for Chinese Channel and English Channel using the [Android flavor](http://tools.android.com/tech-docs/new-build-system/build-system-concepts). Both of the  two version apps have the same package name and the same signature. We can distribute different version to different Android markets. So that it can be accessible by users from different regions.

*app/build.gradle*

```
android {
    productFlavors {
        english {
            applicationId "net.gongmingqm10.localisedandroid"
        }
        chinese {
            applicationId "net.gongmingqm10.localisedandroid"
        }
    }
}

```

The project structure as belows:

```
Root
|--app
	|--src
		|--chinese
			|--java
				|--net.gongmingqm10.localisedandroid
			|--res
				|--layout
				|--values
		|--english
			|--java
				|--net.gongmingqm10.localisedandroid
			|--res
				|--layout
				|--values 
		|--main
			|--java
				|--net.gongmingqm10.localisedandroid
			|--res
				|--layout
				|--values 
			|--AndroidManifest.xml
	|--build.gradle

```

`app/main` is the basic module for this project. Most of the logic will be located here. For the chinese and english flavors. We place the different part to the separate chinese and english package.

## Distribution
Use the gradlew command to generate the different version apps automatically.

Build the Chinese Release version:

```
./gradlew assembleChineseRelease

```
Build the English Release version:

```
./gradlew assembleEnglishRelease

```

Finally, distribute different versions to different Android market. Sure you have to localise all strings in your project, it's good habit to place all strings in strings.xml.

Congratulations, you have already build your localisation App for Chinese market.
