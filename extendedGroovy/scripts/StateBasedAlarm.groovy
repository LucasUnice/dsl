
sensor "button1" pin 8
actuator "LED1" pin 11

state "on" means LED1 becomes high
state "off" means LED1 becomes low

from on to off when button1 becomes high
from off to on when button1 becomes high

initial off

export "StateBasedAlarm"

//     Button HIGH
// +-----------------+
// |                 |
// +                 v
// on               off
// ^                 +
// |                 |
// +-----------------+
//    Button HIGH
