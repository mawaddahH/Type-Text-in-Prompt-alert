# Type-Text-in-Prompt-alert
Discussion  W9D5 - SDA - Software QA Bootcamp


## Table of contents
* [Question](#question)
* [Answer](#answer)
* [Output Screenshots](#output-screenshots)
* [References](#references)

---
## Question
Display the text you wrote by Java code in the prompt alert.
<p align="center">
<img src="https://user-images.githubusercontent.com/48597284/182937055-7f44e22c-2c0a-42a2-b99e-71201ff8bcfd.png" width=80% height=80%>
</p>

## Answer
I used a ["the-internet"](https://www.facebook.com/r.php?locale=en_US) website

### First:
Setup Latest Web Driver for Chrome  Driver.
Donwload the necessary jar files:
- Selenium (Lastest).
- TestNG (Lastest).
- commander (Lastest).

### Second:
Add them as a library in the classpath of the project
- _click-reight on the file project >Build path > configure Bild path > Java Build Path > Libraries > classpath > add external JARs > Apply and close_.

### Third:
steps I used to solve the problem are:
- Write the text
```md
String text = "GOOD JOB Mawaddah";
```

- Write script code
```md
String script = "function jsPrompt() {\n" + "var c = prompt('I am a JS prompt','" + text + "');\n"
				+ "log('You entered: ' + c);\n" + "}\n" + "  function log(msg) {\n"
				+ "    var result = document.getElementById('result');\n" + "    result.innerHTML = msg;\n" + "  }\n";
```

- Add the script in DOM (Document Object Model)
```md
js.executeScript("var s=window.document.createElement('script');" + "s.type = 'text/javascript';" + "s.text = "
				+ script + "window.document.head.appendChild(s);");
```

- Find button element
```md
WebElement jsPrompt = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
```

- SetAttribute for button
```md
js.executeScript("arguments[0].setAttribute('onclick', 'jsPrompt()')", jsPrompt);
```

- Click on the button
```md
js.executeScript("arguments[0].click()", jsPrompt);
```

- Switch to the prompt alert
```md
driver.switchTo().alert();
```

- Click on the "Ok" button
```md
driver.switchTo().alert().accept();
```

---
## Output Screenshots:

<p align="center">
<img src="https://user-images.githubusercontent.com/48597284/182938958-7795d511-345a-4e62-93b6-465e83dd53df.png" width=80% height=80%>

https://user-images.githubusercontent.com/48597284/182940293-2b480225-4d78-47f6-9d80-6e28cbd34107.mp4
</p>

---
## References
- ["How to Add a <script> into Head Using Selenium's JavascriptExecutor"](https://stackoverflow.com/questions/55124506/how-to-add-a-script-into-head-using-seleniums-javascriptexecutor)
- ["How to use JavaScript Executor in Selenium"](https://www.numpyninja.com/post/how-to-use-javascript-executor-in-selenium)
- ["AddElementToPage.java"](https://gist.github.com/sauceaaron/5a590d17b2292ba94390be3f5a620410)
- ["JavaScript Execution with Selenium"](https://www.packt.com/javascript-execution-selenium/)
- ["What are the most common Java Script functions used in Selenium WebDriver?"](https://stackoverflow.com/questions/62091618/what-are-the-most-common-java-script-functions-used-in-selenium-webdriver)
- ["JavaScriptexecutor setAttribute value on selenium"](https://stackoverflow.com/questions/42439570/javascriptexecutor-setattribute-value-on-selenium)
- ["How to use JavascriptExecutor in Selenium"](https://www.browserstack.com/guide/javascriptexecutor-in-selenium#:~:text=Conclusion-,What%20is%20JavascriptExecutor%20in%20Selenium%3F,HTML%20elements%20within%20the%20browser.)
- ["How to select an element that has no attributes"](https://stackoverflow.com/questions/50011892/how-to-select-an-element-that-has-no-attributes)
