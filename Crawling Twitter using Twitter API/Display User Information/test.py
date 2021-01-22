#Name: Mary Shalin Stanley
#Display user information


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


    users= api.lookup_users(screen_names = ['ShalinStanley', 'Twitter'])





    for user in users:
        print("\n User Details:")
        print("Username:", user.name)
        print("Screen Name:", user.screen_name)
        print("User ID:", user.id)
        print("Location:", user.location)
        print("User Description:", user.description)
        print("Followers count:", user.followers_count)
        print("Friends count:", user.friends_count)
        print("Statuses/Tweets count:", user.statuses_count)
        print("User url:", user.url)

        print("Favourites count", user.favourites_count)


    return  #end of main

if __name__=="__main__":
    main()





