#ifndef BALL_H
#define BALL_H


#include <SFML/Graphics.hpp>
#include "../include/paddle.h"

class Ball
{
private:
    sf::CircleShape Object;
    sf::Vector2<float> currentSpeed;

public:

    Ball();

    Ball(float RADIUS, sf::Color COLOR);

    void Init(sf::Vector2f POSITION);

    void deflectX();

    void deflectY();

    // move the ball
    void move();

    void accelerate(Paddle PLAYER);

    void stopMoving();

    void resetSpeed(int sign);

    bool touches(sf::RectangleShape RECTANGLE);
    bool touches(sf::FloatRect RECT);

    sf::Vector2f getBallPosition();

    float getBallRadius();

    sf::CircleShape getObject();

    ~Ball();
};

#endif // BALL_H
