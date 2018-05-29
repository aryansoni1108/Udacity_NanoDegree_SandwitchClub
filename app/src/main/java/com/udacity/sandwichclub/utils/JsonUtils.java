package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        try {
            JSONObject rootObject = new JSONObject(json);
            JSONObject nameObject = rootObject.getJSONObject("name");
            String name = nameObject.getString("mainName");
            JSONArray alsoKnownAs = nameObject.getJSONArray("alsoKnownAs");
            ArrayList<String> alsoKnownAsList = new ArrayList<>();
            for(int i=0;i<alsoKnownAs.length();i++){
                alsoKnownAsList.add(alsoKnownAs.getString(i));
            }
            String placeOfOrigin = rootObject.getString("placeOfOrigin");
            String description = rootObject.getString("description");
            String imageUrl = rootObject.getString("image");
            JSONArray ingredients = rootObject.getJSONArray("ingredients");
            ArrayList<String> ingredientsList = new ArrayList<>();
            for(int i=0;i<ingredients.length();i++){
                ingredientsList.add(ingredients.getString(i));

            }
            return new Sandwich(name,alsoKnownAsList,placeOfOrigin,description,imageUrl,ingredientsList);


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
