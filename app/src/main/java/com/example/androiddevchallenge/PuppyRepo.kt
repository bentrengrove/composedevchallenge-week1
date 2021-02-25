package com.example.androiddevchallenge

import androidx.annotation.DrawableRes

data class Puppy(
    @DrawableRes val resId: Int,
    val name: String,
    val description: String
)

object PuppyRepo {
    val puppies = listOf<Puppy>(
        Puppy(R.drawable.pup_1, "Frank", ""),
        Puppy(R.drawable.pup_2, "Lily", ""),
        Puppy(R.drawable.pup_3, "Johnnie", ""),
        Puppy(R.drawable.pup_4, "Mary", ""),
        Puppy(R.drawable.pup_5, "Pup", ""),
        Puppy(R.drawable.pup_6, "Landry", ""),
        Puppy(R.drawable.pup_7, "Snorlax", ""),
        Puppy(R.drawable.pup_8, "Molly", ""),
        Puppy(R.drawable.pup_9, "Rex", ""),
        Puppy(R.drawable.pup_10, "Pickle", ""),
        Puppy(R.drawable.pup_11, "Grey", ""),
        Puppy(R.drawable.pup_12, "Goldie", ""),
        Puppy(R.drawable.pup_13, "Flop", ""),
        Puppy(R.drawable.pup_14, "Fooie", ""),
        Puppy(R.drawable.pup_15, "Felix", ""),
        Puppy(R.drawable.pup_16, "Liklik", ""),
        Puppy(R.drawable.pup_17, "Poro", ""),
        Puppy(R.drawable.pup_18, "Max", ""),
        Puppy(R.drawable.pup_19, "Bessy", ""),
        Puppy(R.drawable.pup_20, "Lassie", "")
    )
}