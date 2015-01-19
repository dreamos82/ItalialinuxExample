/**
 * Blink a led
 * Questo codice viene utilizzato come esempio nelle lezioni 
 * di Arduino per niubbi su www.italialinux.com
 */
#define LED_PIN 13

void setup(){
  pinMode(LED_PIN, OUTPUT);
}

void loop(){
  digitalWrite(LED_PIN, HIGH);
  delay(500);
  digitalWrite(LED_PIN, LOW);
}
