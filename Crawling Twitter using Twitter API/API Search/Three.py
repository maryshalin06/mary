#Name: Mary Shalin Stanley
#Display first 50 tweets that has prticular keywords / from a region

import const
import tweepy
from tweepy import Stream
from tweepy.streaming import StreamListener


class TweetListener(StreamListener):
    def on_data(self, data):
        print(data)
        return True
    def on_error(self, status):
        print(status)

#define a main() so that the variable will be local to main(), instead of global
def main():
    auth = tweepy.OAuthHandler(const.CONSUMER_KEY, const.CONSUMER_SECRET) #Twitter requires all requests to use OAuth for authentication
    auth.set_access_token(const.ACCESS_TOKEN, const.ACCESS_TOKEN_SECRET) # set access to user's access key and access secret
    api = tweepy.API(auth) # calling the api
    api = tweepy.API(auth, wait_on_rate_limit=True)
    twitterStream =(auth, TweetListener())
    search_result = api.search(q = ['Ohio', 'weather'], count = 50)
    searches = api.search(geocode="39.758949,-84.191605,25mi", count=50)
    c=1;
    d=1;
    print("\n ******* a).Results for first 50 tweets that contain these two keywords: [Ohio,weather]*******")
    for search in search_result:
        print("Tweet", c, ":", search.text)
        c=c+1;
    print("\n ******* b).Results for first 50 tweets that originated from Dayton region *******")
    for searched in searches:
        print("Tweet",d,":", searched.text)


        d=d+1;

    return  #end of main

if __name__=="__main__":
    main()
