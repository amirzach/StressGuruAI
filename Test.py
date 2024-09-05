import random

greetings = ["Hello!", "What's up?!", "Howdy!", "Greetings!"]
goodbyes = ["Bye!", "Gooddbye!", "See you later!", "See you soon"]
keywords = ["music", "pet", "book", "game", "created", "sentient", "capabilities"]
responses = ["Music is so relaxing!", "Dogs are man's best friend!", "I know about a lot of books.", "I like to play video games.", "I was created by Kaz on the 19th of August 2024", "I am not sentient yet because all of my answers have been predetermined by Kaz", "As far as you're concerned, i am only able to answer simple inquiries"]

print(random.choice(greetings))
print("I am a chatbot designed for basic conversations with you")
user = input("Say something for me to comment on (or type bye to quit): ")
user = user.lower()

while (user!= "bye"):
    keyword_found = False
    
    for index in range(len(keywords)):
        if (keywords[index] in user):
            print("Bot: "+responses[index])
            keyword_found = True
    
    if (keyword_found == False):
        new_keyword = input("I'm not sure how to respond to that. What specific keyword should I respond to? ")
        keywords.append(new_keyword)
        new_response = input("How should i respond to "+new_keyword+"? ")
        responses.append(new_response)
    
    user = input("Say something for me to comment on (or type bye to quit): ")
    user = user.lower()
    
print(random.choice(goodbyes))