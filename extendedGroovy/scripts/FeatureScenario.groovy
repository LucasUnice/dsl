
sensor "button1" onPin 9
actuator "LED1" pin 12

state "on" means LED1 becomes high
state "off" means LED1 becomes low

initial off

from on to off when time becomes 800
from off to on when button1 becomes high

export "Switch!"