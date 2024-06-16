import random
import string

# Define the character sections
section1 = "Ü" + "Ö" + "Ş" + "Ç" + "Ğ" + "İ" + "ü" + "ö" + "ş" + "ç" + "ğ" + "ı" + " "
section2 = string.punctuation
section3 = string.ascii_letters
section4 = string.digits

#chars = section1 + section2 + section3 + section4
#chars = list(chars)

#numbers = 1, 2, 3, 4

def create_key_from_firstkey(firstkey):
    sections = [section1, section2, section3, section4]
    new_chars = ""
    for num in firstkey:
        new_chars += sections[int(num) - 1]
    return list(new_chars)

choice = input("Encrypt or Decrypt. (E/D)")

if choice in "E":
    omessage = input("Enter your message: ")
    firstkey = input("Enter your first key (combination of 1-4): ")
    #firstkey = random.sample(numbers, len(numbers))
    
    # Create the new character set based on firstkey
    chars = create_key_from_firstkey(firstkey)
    
    # Generate a shuffled key
    key = chars.copy()
    random.shuffle(key)
    
    # Encrypt the message
    ecmessage = ""
    for letter in omessage:
        index = chars.index(letter)
        ecmessage += key[index]
    
    print(f"Encrypted message: {ecmessage}")
    
    def convert(key):
        dkey = ""
        for x in key:
            dkey += x
        return dkey
    
    print("Key: ", convert(key))
    print("First key: ", firstkey)
    input("Enter any key to exit!")

elif choice in "D":
    ecmessage = input("Enter your message: ")
    firstkey = input("Enter your first key (combination of 1-4): ")
    key = input("Enter your key: ")
    
    # Create the new character set based on firstkey
    chars = create_key_from_firstkey(firstkey)
    
    # Decrypt the message
    omessage = ""
    for letter in ecmessage:
        index = key.index(letter)
        omessage += chars[index]
    
    print(f"Original message: {omessage}")
    input("Enter any key to exit!")
    
else:
    print('Are you an idiot?')
    input("Enter any key to exit!")
