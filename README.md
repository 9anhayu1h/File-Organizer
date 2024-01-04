## Project Team
Project Lead: Panhayuth Oeun

Project Team: Keb Sreynaj

Additional Stakeholders: **lecturer Lay Vathna**

# I. Introduction
The File Organizer Application is designed to help users organize their files based on their types. 
The application utilizes various classes and interfaces to achieve efficient file organization.

## Project Overview
Users often encounter the problem of spending a lot of time organizing a messy folder. 
When files are all over the place and not organized properly, it becomes hard to find specific files and keep a well-organized file system. 



## II. Functionality
**The main functionality of the File Organizer application includes the following:**

**1, Organizing Files:**
The core feature of the application is to organize files based on their file extensions or specific criteria. 
The application iterates through all the files in the specified folder, identifies their file extensions, and moves them to the corresponding subfolder.

**2, File Extension Count:**
The application can count the number of files with each file extension present in a specified folder. 
This functionality helps users understand the distribution of file types within a folder.

**3. Creating Subfolders:**
The application can create subfolders within the main folder to organize files systematically. 
Each subfolder corresponds to a specific file type or category.


## III. Implementation:

### Classes & Objects:
The file organizer application utilizes multiple classes to represent different types of folders for organizing files. 
Each class encapsulates specific functionalities and properties related to file organization. 
Objects of these classes are created and utilized within the Main class to organize files based on their type.


### Inheritance:
The code demonstrates inheritance by utilizing a superclass-subclass relationship between the Folder class and its specialized subclasses (Documents, Picture, etc.). 
The subclasses inherit properties and methods from the Folder class and provide their own implementations when necessary.

### Constructor:
The Folder class has a constructor that initializes the folderName property. 
Subclasses like Documents, Picture, etc., invoke the superclass constructor using the super keyword to ensure proper initialization of inherited properties.
[Example of constructor](https://github.com/9anhayu1h/File-Organizer/blob/main/NewCode/Folder.java)

### Overriding method:
The subclasses (Documents, Picture, etc.) override the organizeFile method defined in the Folder class. 
Method overriding allows subclasses to provide their own implementation of inherited methods.

### Polymorphism: Casting
Polymorphism is demonstrated through method overriding and the usage of an anonymous inner class in the Main class. 
Polymorphism allows objects of different classes to be treated as objects of a common superclass (Folder in this case), promoting flexibility and extensibility of the code.

### Encapsulation: Access Modifiers
Access modifiers are used to encapsulate the properties and methods of classes,providing control over their visibility and accessibility. 
In the file organizer application, access modifiers such as public, private, protected, and default (no modifier) are used to enforce encapsulation.

### Abstraction: Abstract Class or Interface
The Folder class is defined as an abstract class using the abstract keyword. 
Abstract classes cannot be instantiated directly but serve as blueprints for subclasses. 
The Folder class declares an abstract method organizeFile, which is implemented in its subclasses.

### Exception handling:
The organizeFile method in the Folder class and its subclasses declare to throw an IOException, indicating that the method can potentially encounter an I/O exception. 
Exception handling is not explicitly implemented in the provided code, but the declaration of the IOException allows for handling potential errors when performing file operations.

### File I/O:
The FileIO class provides methods for saving a FolderNameAndPath object to a file using serialization. 
The setFilePath method sets the file path for saving the object, and the saveToFile method serializes the FolderNameAndPath object and saves it to the specified file path. Serialization allows objects to be converted into a byte stream for storage or transmission.

### Anonymous Inner Class or Functional Interface/Lambda Expression:
An anonymous inner class is used in the Main class to override the countExtensions method of the Documents class. 
The anonymous inner class provides a custom implementation of the countExtensions method without explicitly creating a separate class.

### Static method:
The Main class contains several static methods such as main, createSubFolder, and organizeFiles. 
Static methods belong to the class itself rather than individual objects and can be accessed without creating an instance of the class.






