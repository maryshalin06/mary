#Name: Mary Shalin Stanley
#IDEA : code to deliver tweets of your interest to your email at 8:00AM every day

import smtplib
import const
import tweepy
from tweepy import Stream
from tweepy.streaming import StreamListener
from datetime import datetime, timedelta
from threading import Timer


from string import Template

from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText

#Refer the ReadMe document attached along
MY_ADDRESS = 'insertYourEmailID'
PASSWORD = 'yourPassword'

#for the time condition I have kept two methods convinence - method1: to trigger emails at 8am everyday method2: To satisfy a time condition that is see if the mail is triggered at the given time
x=datetime.today()
print("x: ", x)
hour = int(x.hour)
min = int(x.minute)
print("hours and minutes: ", hour, min)

#This is to trigger the email everyday at 8 am (method 1) comment these if you're using method 2
y = x.replace(day=x.day, hour=8, minute=0, second=0, microsecond=0) + timedelta(days=1)
delta_t=y-x
secs=delta_t.total_seconds()

def get_contacts(filename):
    """
    Return two lists names, emails containing names and email addresses
    read from a file specified by filename.
    """

    names = []
    emails = []
    with open(filename, mode='r', encoding='utf-8') as contacts_file:
        for a_contact in contacts_file:
            names.append(a_contact.split()[0])
            emails.append(a_contact.split()[1])
    return names, emails

def read_template(filename):
    """
    Returns a Template object comprising the contents of the
    file specified by filename.
    """

    with open(filename, 'r', encoding='utf-8') as template_file:
        template_file_content = template_file.read()
    return Template(template_file_content)

class TweetListener(StreamListener):
    def on_data(self, data):
        print(data)
        return True
    def on_error(self, status):
        print(status)

def main():
    auth = tweepy.OAuthHandler(const.CONSUMER_KEY, const.CONSUMER_SECRET) #Twitter requires all requests to use OAuth for authentication
    auth.set_access_token(const.ACCESS_TOKEN, const.ACCESS_TOKEN_SECRET) # set access to user's access key and access secret
    api = tweepy.API(auth) # calling the api
    api = tweepy.API(auth, wait_on_rate_limit=True)
    twitterStream =(auth, TweetListener())
    search_result = api.search(q = ['Cooking', 'News'], count = 5)

    names, emails = get_contacts('mycontacts.txt') # read contacts
    message_template = read_template('message.txt')

    # set up the SMTP server
    s = smtplib.SMTP(host='smtp-mail.outlook.com', port=587)
    s.starttls()
    s.login(MY_ADDRESS, PASSWORD)


    for name, email in zip(names, emails):
        msg = MIMEMultipart()

        text = "Hello Mary! Here are some of the tweets for the day"
        string_length=len(text)+10    # will be adding 10 extra spaces
        txt= text.center(string_length)

        msg.attach(MIMEText(txt, 'plain'))


        i = 1
        for search in search_result:
            message = "\n Tweet" +str(i) + ":" +search.text + "\n"
            i=i+1
            print(message)
            msg.attach(MIMEText(message, 'plain'))

        # setup the parameters of the message
        msg['From']=MY_ADDRESS
        msg['To']=email
        msg['Subject']="Twitter Highlights for the day"



        #msg.attach(MIMEText(message, 'plain'))


        # send the message via the server set up earlier.
        #if hour == 21 and min == 2:  #Method2: Uncomment this condition to check to see if the mail triggers only in the given hour and time
        s.send_message(msg)
        del msg

    # Terminate the SMTP session and close the connection
    s.quit()
#Comment these method 1 codes to check method 2 for time
t = Timer(secs, main)
t.start(#Name: Mary Shalin Stanley
#Task2.5 4: IDEA : code to deliver tweets of your interest to your email at 8:00AM every day

import smtplib
import const
import tweepy
from tweepy import Stream
from tweepy.streaming import StreamListener
from datetime import datetime, timedelta
from threading import Timer


from string import Template

from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText

#Refer the ReadMe document attached along
MY_ADDRESS = 'insertYourEmailID'
PASSWORD = 'yourPassword'

#for the time condition I have kept two methods convinence - method1: to trigger emails at 8am everyday method2: To satisfy a time condition that is see if the mail is triggered at the given time
x=datetime.today()
print("x: ", x)
hour = int(x.hour)
min = int(x.minute)
print("hours and minutes: ", hour, min)

#This is to trigger the email everyday at 8 am (method 1) comment these if you're using method 2
y = x.replace(day=x.day, hour=8, minute=0, second=0, microsecond=0) + timedelta(days=1)
delta_t=y-x
secs=delta_t.total_seconds()

def get_contacts(filename):
    """
    Return two lists names, emails containing names and email addresses
    read from a file specified by filename.
    """

    names = []
    emails = []
    with open(filename, mode='r', encoding='utf-8') as contacts_file:
        for a_contact in contacts_file:
            names.append(a_contact.split()[0])
            emails.append(a_contact.split()[1])
    return names, emails

def read_template(filename):
    """
    Returns a Template object comprising the contents of the
    file specified by filename.
    """

    with open(filename, 'r', encoding='utf-8') as template_file:
        template_file_content = template_file.read()
    return Template(template_file_content)

class TweetListener(StreamListener):
    def on_data(self, data):
        print(data)
        return True
    def on_error(self, status):
        print(status)

def main():
    auth = tweepy.OAuthHandler(const.CONSUMER_KEY, const.CONSUMER_SECRET) #Twitter requires all requests to use OAuth for authentication
    auth.set_access_token(const.ACCESS_TOKEN, const.ACCESS_TOKEN_SECRET) # set access to user's access key and access secret
    api = tweepy.API(auth) # calling the api
    api = tweepy.API(auth, wait_on_rate_limit=True)
    twitterStream =(auth, TweetListener())
    search_result = api.search(q = ['Cooking', 'News'], count = 5)

    names, emails = get_contacts('mycontacts.txt') # read contacts
    message_template = read_template('message.txt')

    # set up the SMTP server
    s = smtplib.SMTP(host='smtp-mail.outlook.com', port=587)
    s.starttls()
    s.login(MY_ADDRESS, PASSWORD)


    for name, email in zip(names, emails):
        msg = MIMEMultipart()

        text = "Hello Mary! Here are some of the tweets for the day"
        string_length=len(text)+10    # will be adding 10 extra spaces
        txt= text.center(string_length)

        msg.attach(MIMEText(txt, 'plain'))


        i = 1
        for search in search_result:
            message = "\n Tweet" +str(i) + ":" +search.text + "\n"
            i=i+1
            print(message)
            msg.attach(MIMEText(message, 'plain'))

        # setup the parameters of the message
        msg['From']=MY_ADDRESS
        msg['To']=email
        msg['Subject']="Twitter Highlights for the day"



        #msg.attach(MIMEText(message, 'plain'))


        # send the message via the server set up earlier.
        #if hour == 21 and min == 2:  #Method2: Uncomment this condition to check to see if the mail triggers only in the given hour and time
        s.send_message(msg)
        del msg

    # Terminate the SMTP session and close the connection
    s.quit()
#Comment these method 1 codes to check method 2 for time
t = Timer(secs, main)
t.start()

if __name__ == '__main__':
    main()

