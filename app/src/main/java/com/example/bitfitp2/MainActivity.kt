/***
# Android Project 6 - *BitFit Part 2*

Submitted by: **Rothmel Fortune II**

**BitFitp2** is a health metrics app that allows users to track ... [TODO]

Time spent: **24** hours spent in total

## Required Features

The following **required** functionality is completed:

- [/ ] **Use at least 2 Fragments**
- [/ ] **Create a new dashboard fragment where users can see a summary of their entered data**
- [/ ] **Use one of the Navigation UI Views (BottomNavigation, Drawer Layout, Top Bar) to move between the fragments**

The following **optional** features are implemented:

- [ ] **Add a more advanced UI (e.g: Graphing) for tracking trends in metrics**
- [ ] **Implement daily notifications to prompt users to fill in their data**

The following **additional** features are implemented:

- [ ] List anything else that you can get done to improve the app functionality!

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='http://i.imgur.com/link/to/your/gif/file.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />

<!-- https://media.giphy.com/media/v1.Y2lkPTc5MGI3NjExdWw2MHZzOTBmdWl0bXcxN2E5aWo3NDg4aGtwZnVpNGNvdHZlcmpsbSZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/KzsQyWEP0pt7pwmLu7/giphy.gif -->
GIF created with ...
<!-- Recommended tools:
[Kap](https://getkap.co/) for macOS
[ScreenToGif](https://www.screentogif.com/) for Windows
[peek](https://github.com/phw/peek) for Linux. -->

## Notes

'I had to make a new version of bitfit app since the odd
one wasn't cooperating, so this has the original function
with new features'

Describe any challenges encountered while building the app.

## License

Copyright [2024] [name of copyright owner]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
**/

package com.example.bitfitp2


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recordFragment: Fragment = com.example.bitfitp2.FoodRecordFragment()
        val dashboardFragment: Fragment = com.example.bitfitp2.DashboardFragment()
        val addEntryFragment: Fragment = com.example.bitfitp2.AddEntryFragment()

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)

        bottomNavigationView.setOnItemSelectedListener { item ->
            lateinit var fragment: Fragment
            when (item.itemId) {
                R.id.Record -> fragment = recordFragment
                R.id.Dashboard -> fragment = dashboardFragment
                R.id.AddEntry -> fragment = addEntryFragment
            }
            replaceFragment(fragment)
            true
        }

        bottomNavigationView.selectedItemId =R.id.Record
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager =supportFragmentManager
        val fragmentTransition = fragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.content, fragment)
        fragmentTransition.commit()
    }
}