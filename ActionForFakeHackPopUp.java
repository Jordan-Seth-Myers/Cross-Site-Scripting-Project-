int delaytime = 200; // Delay to show process

void submitKey(int key) { // Use to press enter
  Keyboard.press(key);
  delay(50);
  Keyboard.release(key);
}

void openCMD() { // Function to open cmd prompt
  Keyboard.press(KEY_LEFT_GUI);
  Keyboard.press(114);
  Keyboard.releaseAll();
  delay(delaytime);

  Keyboard.print("cmd");
  submitKey(KEY_RETURN);
  delay(delaytime);
}

void createfile(int x) { // Creates a file
  Keyboard.print("cd hacked");
  submitKey(KEY_RETURN);
  delay(delaytime);
  
  String String1 = "echo You've been hacked > rip";
  String String2 = ".txt";
  String temp = String1 + x + String2; // Creates rip[x].txt file (x is position in main loop)
  Keyboard.print(temp);
  submitKey(KEY_RETURN);
  delay(delaytime);

  String1 = "rip";
  temp = String1 + x + String2;
  Keyboard.print(temp); // Opens file
  submitKey(KEY_RETURN);
  delay(delaytime);
}

void setup() {
  Mouse.begin();
  Keyboard.begin(); // Starts emulating keyboard and mouse
  delay(1000);

  openCMD();

  Keyboard.print("cd /");
  submitKey(KEY_RETURN);
  delay(delaytime);
  Keyboard.print("mkdir hacked"); // Create "hacked directory"
  submitKey(KEY_RETURN);
  delay(delaytime);
  
  for (int i = 0; i < 2; i++) { // Loop to generate text files in "hacked" directory
    openCMD();
    Keyboard.print("cd /");
    submitKey(KEY_RETURN);
    delay(delaytime);
    createfile(i); // Calls function to iteratively create files within loop
    delay(500);
  }
  
  openCMD();
  Keyboard.print("start opera https://geekprank.com/fake-virus/"); // Open fake "YOUVE BEEN HACKED" site
  submitKey(KEY_RETURN);                                           // Could instead send to actual site containing virus or wherever else I please
  delay(500);
  
  Keyboard.end();
  Mouse.end(); // Stops emulation of keyboard and mouse
}

void loop() {
  
}