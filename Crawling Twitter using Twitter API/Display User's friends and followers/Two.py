#Name: Mary Shalin Stanley
#Display friends and 20 followers
import tweepy
import const


auth = tweepy.OAuthHandler(const.CONSUMER_KEY, const.CONSUMER_SECRET)


auth.set_access_token(const.ACCESS_TOKEN, const.ACCESS_TOKEN_SECRET)


api = tweepy.API(auth)
users= api.lookup_users(screen_names = ['ShalinStanley', 'tim_cook'])
lst1 = []
lst2 = []


for user in users:
    print("\n Screen Name:", user.screen_name)
    print('\033[1m'+ "*** List of friends according to Twitter API ***" + '\033[0m') #displaying this for my own understanding. According to this API, it displays users whom I follow
    for friend in user.friends():
        lst1.append(friend.name)
    for i in range (0, len(lst1)):
        print(lst1[i])

    print('\033[1m'+ "*** First 20 followers ***" + '\033[0m') #Answer for displaying 20 followers
    for follower in user.followers():
        lst2.append(follower.name)
    for i in range (0, len(lst2)):
        print(lst2[i])
    #Answer for displaying friends who follow each other (Bidirectional)
    print('\033[1m'+ "Friends (bidirectional):" + '\033[0m') #Intersecting the results of the above two API to find friends (people who follow each other-bidirectional)
    intersection = list(set(lst1)& set(lst2))
    print(*intersection, sep = "\n")
    if(len(intersection) == 0):
        print("No friends for this user!")
    lst1.clear()
    lst2.clear()




