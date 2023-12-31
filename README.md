# encryption-decryption

Privacy is an important matter is the realm of the Internet. When sending a message, you want to be sure that no-one but the addressee with the key can read it. The entirety of the modern Web is encrypted - take https for example! Don’t stay behind: hop on the encryption/decryption train and learn the essential basics while implementing this simple project.

## Usage Example:

When starting the program, the necessary algorithm should be specified by an argument (-alg). Name the first algorithm as shift, the second one as unicode. If there is no -alg argument, default it to shift.

Remember that in case of shift, encode only English letters — from "a" to "z" and from "A" to "Z". In other words, after "z" comes "a", after "Z" comes "A".

Example 1: reading and writing to files; the arguments are: -mode enc -in road_to_treasure.txt -out protected.txt -key 5 -alg unicode

This command must get data from road_to_treasure.txt, encrypt the data with the key of 5, create protected.txt, and write ciphertext into it.

Example 2: encryption with the unicode algorithm; the arguments are: -mode enc -key 5 -data "Welcome to hyperskill!" -alg unicode

#### \jqhtrj%yt%m~ujwxpnqq

Example 3: decryption with the unicode algorithm; the arguments are: -key 5 -alg unicode -data "\jqhtrj%yt%m~ujwxpnqq&" -mode dec

### Welcome to hyperskill!
Example 4: encryption with the shift algorithm; the arguments are: -key 5 -alg shift -data "Welcome to hyperskill!" -mode enc

### Bjqhtrj yt mdujwxpnqq!
Example 5: decryption with the shift algorithm; the arguments are: -key 5 -alg shift -data "Bjqhtrj yt mdujwxpnqq!" -mode dec

### Welcome to hyperskill!
