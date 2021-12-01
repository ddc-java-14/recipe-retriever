---
title: Overview description: What is Recipe Retriever? menu: Overview order: 0
---

## Summary

<i> Recipe Retriever </i> is a simple android app that lets the user: sign into their Google account, 
search through the database for recipes and selecting the recipe that they would like to see 
ingredients for, step-by-step breakdown of how to make the recipe and then decide on saving these 
recipes by pressing the "heart" to save into their Favorite Recipe tab.

## Intended users

* Someone looking to experiment with their taste buds.

  > As someone bored with the same old recipes, I want an app that lets me search for new recipes 
  > by typing in a word and choosing from the list, a recipe I would like to make.

* Someone looking to try a new recipe.

  > As an amateur cook looking to try a new recipe at home, I want an app that lets me choose a 
  > selected recipe or shuffle through different recipes that are stored inside the app.

## Functionality

App will have a search bar that wants the user to:

* Type in a search word:
    * Chose recipe from the options.
    * view the ingredients and steps assocaited with that recipe.
* User can then favorite the recipe if they desire to.
* User will be able to go into the settings and decide how many recipes to show.

## Persistent data

* List of recipes.
* Ingredients for recipes.
* Macronutrient information of selected recipe.

## Device/external services

* Service: Google Sign-in

## Technical Requirements and Dependencies

* <i> Recipe Retriever </i> is using Google Sign-in, Retrofit, ReactiveX and Gson.
* This app was tested using Pixel 3a API 29 emulator.
* This app needs permission to internet.

### [Recipe's API](https://spoonacular.com/food-api/docs)

* Once the user types in a search term, the app will make a request to the server, a list of recipe
  titles that you can search through and choose which one you would like to view details about.
* If internet access is unavailable, user will be able to view all favorited recipes; however, they
  will not be able to search for new ones.
  
## Stretch goals/possible enhancements

* User will be able to save a large amount of recipes on their phone that they can access for later
  times.
* User will be able to shuffle/ press "random recipe" button to show a list of random recipes to
  try.
* User will be able to search for a recipe by the specific ingredient(s) of their choosing.

## Summary of Current State

* This app currently does not show any items on the emulator itself. When search term is typed in
  however, an array of recipe titles show in the logcat of IntelliJ.
* Since nothing shows inside the app, user currently cannot save a recipe as their favorite.

## Build Instructions

* From the, <i> Recipe Retriever </i>, GitHub repository, click on the "Code" button, making sure "
  SSH" is underlined and then click on the small button with the overlapping squares. This will copy
  the repository url and save it to your clipboard.
* Go to IntelliJ and select "New Project from Git Version Control" and paste the link you copied
  from GitHub into the space provided.

## Basic User Instructions

* Sign-in to your Google account.
* Press the button with the 3 horizontal lines, and select "Search Recipe"
* Enter a word in the search word bar and press the magnifying glass icon for recipe(s) to appear.
* If you want to save the recipe, press the heart button to save.

## Copyright Notice

Copyright 2021 Nicholas Mitchell.

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is
distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
implied. See the License for the specific language governing permissions and limitations under the
License.