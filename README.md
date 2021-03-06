![ezgif com-gif-maker (1)](https://user-images.githubusercontent.com/20436225/115594260-2798a580-a2f3-11eb-81a5-fb44768a3622.gif)


# Android Animated Progress Button
## 

Animated Progress Loding Button with multiple functionality.

- Loading Animation
- Error Animation
- Success Animation


## Features
- Custom Button Drawable
- Custom Button Color
- Custom Progress Color
- Custom Success Icon
- Custom Error Icon
- Custom Button Success Color
- Custom Button Error Color
- Change Text Color
- Custom Font Style

- No Additional Code Required
- Fully Customizable
- Easy to Implement

## Code Sample
 - Xml
  
 ```sh
  <com.rk.progressbutton.RkProgressButton
        android:id="@+id/progress_button"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:buttonErrorText="Retry"
        app:buttonText="Login"
        app:buttonDrawable="@drawable/btn_bg"
        app:buttonColor="@color/blue"
        app:buttonErrorColor="@color/red"
        app:buttonSucessColor="@color/green"
        app:progressColor="@color/white"
        app:doneColor="@color/black"
        app:textColor="@color/white" />
```

 * Start Progress Animation  
 ```sh
 progressButton.progressAnimation()
```
* Success Animation
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
        implementation 'com.github.smartrk:ProgressButton:1.4' 
}
```
