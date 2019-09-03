#Autonomous Intersection Management
## Introduction

I started this project after watching a [video](http://https://www.youtube.com/watch?v=4pbAI40dK0A "video") about autonomous intersection management by a research team at the University of Texas. I wanted to adapt this to quantify the improvements in traffic safety and volume compared to traditional intersection management.

-----
#### Algorithm Overview (from video)
When a car enters the intersection, it must reserve a safe path through it. The intersection is represented by a Grid, and divided by Squares. In specific, the car must reserve a path of Squares through the intersection. If a sufficient path cannot be reserved, it will reserve as much as it can and slow down to an appropriate speed to allow the car to remain in the reserved path for the given time step.

-----
#### Assumptions
- Car and Square lengths and widths are all 15 feet
- Each time step is 1/3 second
- Default car speed is 30 mph
- No human input
- Path lengths to reserve are calculated based on braking distance required at given speeds ([source](https://www.drivingtestsuccess.com/blog/safe-separation-distance "source"))
-----

#### Implementation

##### Simulation.java
- Holds a grid representing the intersection
- Holds list of all cars
- Runs simulation in the broader scope

##### Grid.java
- Representation of intersection, made up of Squares

##### Square.java
- Holds list of available times to reserve the Square
- Makes up Grid

##### Car.java
- Contains unique id, acceleration, deceleration, current speed, current location, current reservations

##### Direction.java
- Enum describing which cardinal direction car is facing

-----
#### Future iterations
- Use real traffic data to simulate real intersections during certain times
- Change weather conditions (different braking distance)
- Simulate different traffic densities and patterns
- Use a decentralized system
- Safeguards against bad actors (hackers)
- Add a visualization
- Create a traditional intersection simulation to compare against AIM
- Change acceleration and braking speeds based on car
- Calculate gas savings, safety improvements at constant traffic volume, volume improvements at constant safety threshold