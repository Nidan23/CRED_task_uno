# Simple coding task - a file differentiator

1. Use Google Drive and send us back a information when you done it.
2. Initialize the local git repo before starting work and commit your changes to it. 
Remember to include the `.git` folder in the solution archive (solutions without a git repository will not be checked).
3. Just Java and JUnit, no external libraries allowed (or necessary).
4. We wish to see object-oriented programming, so use this as an opportunity to showcase your skills.
5. Code a solution to handle "magic numbers" for images and text files. 
6. Remember to prepare at least basic unit tests (you can use JUnit library). 

## Drawing - optional step

We accept drawings of your design, if you decide to draw anything before you start coding. Just photograph them and add them to your Google Drive catalog, with a text file explaining what is on a drawing (if needed). This is **NOT** a required step.

## File differentiator

There are various people and not everyone is honest. Some would pretend a file is a JPG, while in fact, it's a dangerous, malicious binary. 
Write a program, that prevents that from happening!

1. You accept all extensions. No matter the extension, attempt at reading will be done.
2. You verify "magic numbers". 
3. Program must say if the extension is true (a txt file is a text file, an JPG is a JPG).
4. If extension isn't handled, program honestly states so (throwing an appropriate exception, one that fits this situation).
5. We expect JPGs, GIFs and TXT files to be handled. Anything more is a plus.
6. If extension lies, program states: Extension is A, while actually it's a B.

Anything that is NOT stated in the above list, is not necessary. Console-only program is absolutely fine, no GUI is necessary. 

## Magic numbers?!

If you never heard of magic numbers, don't worry. Here are good resources to study:

1. Unix `file` command, which tells you what a file is.
2. https://en.wikipedia.org/wiki/List_of_file_signatures
3. https://en.wikipedia.org/wiki/File_format#Magic_number
4. https://en.wikipedia.org/wiki/Magic_number_(programming)#Magic_numbers_in_files

## Brownie points
Show us your way of thinking by programming using the TDD methodology.

## Closing remarks

Looking at how number of people approach such tasks, we have some remarks:

1. Your performance will be taken into account along with other stages of the hiring process (including previous ones)
2. OO may be more tricky and/or important than you think.