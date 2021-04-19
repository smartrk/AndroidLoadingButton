<img src="https://drive.google.com/file/d/1TI8wJOo2WzR26gI-QXw-FjuyyVQX646d/view?usp=sharing">


# Progess Button
## 

Animated Material Progress Button with manage multiple functionality.

- Progress Animation
- Error Animation
- Successfull Animation
- Custom Button Color
- Custom Progress Color
- Custom Sucessfull Icon
- Custom Error Icon


## Features
- No Aditional And Extra Code Required
- Fully Customizable
- Easy to implement

## Code Sample
 - Xml
  
 ```sh
  <com.rk.progressbutton.RkProgressButton
        android:id="@+id/progress_button"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:buttonColor="@color/red"
        app:buttonErrorText="Retry"
        app:buttonText="Login"
        app:progressColor="@color/white"
        app:textColor="@color/white" />
```

 * Start progress animation  
 ```sh
 progressButton.progressAnimation()
```
* Suceessfull Animation
 ```sh
 progressButton.doneAnimation()
```
* Error Animation
 ```sh
 progressButton.errorAnimation()
```
 * Stop Animation
 ```sh
 progressButton.stopAnimation()
```

 


 


## Gradle dependency

```sh
dependencies { 
        implementation 'com.github.smartrk:ProgressButton:1.1' 
}
```
