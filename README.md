# How to use a SE API key
You came up with an idea of a Java app that deals with [Stack Exchange](http://stackexchange.com). You discovered that [they have an API so there's no need to scrape pages](https://api.stackexchange.com). You then found out that apps that don't have an API key get to make really few requests between two UTC midnights, so you [went get a key](http://stackapps.com/apps/oauth/register).

But, one problem remains: **How on earth are you going to use that key?**

The .java file in this repository demonstrates just that by fetching general info about [Stack Overflow](http://stackoverflow.com/tour) with an API key.

---

Here's an overview of the workflow in that .java file (with "you" being "the program"):

- **Step 1)** You open a connection to `https://api.stackexchange.com/2.2/info?site=stackoverflow&key=YOUR_API_KEY_HERE`.
- **Step 2)** The API packs miscellaneous facts about Stack Overflow into a JSON object, GZIPs it, and sends it to you.
- **Step 3)** You unGZIP the JSON you just got and use it (in this case, by printing it to `System.out`).

You might notice a difference when reading the JSON. Without a key, the JSON looks like this (without all the whitespace of course, I added them for readability):

<pre>{
  "items": [
    {
      "new_active_users": 17,
      "total_users": 6451004,
      "badges_per_minute": 4.72,
      "total_badges": 20788919,
      "total_votes": 92571680,
      "total_comments": 63593718,
      "answers_per_minute": 4.67,
      "questions_per_minute": 2.94,
      "total_answers": 20573764,
      "total_accepted": 7043247,
      "total_unanswered": 3621881,
      "total_questions": 12949924,
      "api_revision": "2016.12.6.24026"
    }
  ],
  "has_more": false,
  "quota_max": 300,
  "quota_remaining": 240
}</pre>

With a key, it looks like this (note that `quota_max` went up by a lot):

<pre>{
  "items": [
    {
      "new_active_users": 17,
      "total_users": 6451004,
      "badges_per_minute": 4.72,
      "total_badges": 20788919,
      "total_votes": 92571680,
      "total_comments": 63593718,
      "answers_per_minute": 4.67,
      "questions_per_minute": 2.94,
      "total_answers": 20573764,
      "total_accepted": 7043247,
      "total_unanswered": 3621881,
      "total_questions": 12949924,
      "api_revision": "2016.12.6.24026"
    }
  ],
  "has_more": false,
  "quota_max": 10000,
  "quota_remaining": 9940
}</pre>
