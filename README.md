# Purdue-Swipes

## Inspiration

As new Purdue students, we have found it difficult to know which places take meal swipes, as well as when they take them and what you can get with them. This is a problem that has been exacerbated by the restrictions put in place to stop the spread of COVID-19, with lines to well-known locations being wrapped around the building at times. We wanted a one-stop shop for everything to do with using meal swipes.

## What it does

Purdue Swipes pulls information about restaurants such as name, times open for swipes, and swipe menus from our Firebase database and populates a screen where the use can scroll through and see all restaurants that take meal swipes. There is also a button that launches Google Maps to direct the user to the restaurant. When the user clicks on one of the restaurants, they can toggle between viewing all days and times that the restaurant is open for swipes, and a menu that displays all swipe options.

## How we built it

We built our app using Android Studio and Firebase.

## Challenges we ran into

We had difficulty iterating through the data, uploading that data to the database, then pulling it back from the database and displaying it in a readable format. It was very challenging to deal with time comparison to check if a restaurant was open, because we had to parse String data stored in Firebase and compared that with data taken from the user's phone. We were not able to finish the filter to display restaurants close to the user as we did not have enough time left after implementing our other features.

## Accomplishments that we're proud of

We are proud that we were able to make a color-coded display of whether or not a restaurant was open, as that was a feature that really improves the user experience, but was challenging to implement.

## What we learned

We all gained valuable experience in using GitHub to manage a group project.

## What's next for Purdue Swipes

We would like to fully implement functionality to show the users which restaurants are closest to them.
