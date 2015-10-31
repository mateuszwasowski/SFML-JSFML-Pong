#include "../include/Ball.h"

sf::Vector2<float> BallSpeed(0.3, 0.3);

Ball::Ball()
{
}

Ball::Ball(float RADIUS, sf::Color COLOR)
{
    Object.setRadius(RADIUS);
    Object.setFillColor(COLOR);

}

void Ball::Init(sf::Vector2f POSITION)
{
    Object.setPosition(POSITION);
    currentSpeed = BallSpeed;
}

void Ball::deflectX()
{
    currentSpeed.x = -currentSpeed.x;
}

void Ball::deflectY()
{
    currentSpeed.y = -currentSpeed.y;
}

void Ball::accelerate(Paddle PLAYER)
{
    currentSpeed.y = (Object.getGlobalBounds().top
                      + Object.getGlobalBounds().height / 2
                      - PLAYER.getObject().getGlobalBounds().top
                      - PLAYER.getObject().getGlobalBounds().height / 2) / 100;
}

void Ball::stopMoving()
{
    currentSpeed = sf::Vector2<float>(0.0f, 0.0f);
}
void Ball::resetSpeed(int sign)
{
    currentSpeed = BallSpeed;
    BallSpeed.y = BallSpeed.y * sign;
    BallSpeed.x = BallSpeed.x * sign;
}

bool Ball::touches(sf::RectangleShape RECTANGLE)
{
    if(Object.getGlobalBounds().intersects(RECTANGLE.getGlobalBounds()))
        return true;
    return false;
}

bool Ball::touches(sf::FloatRect RECT)
{
    if(Object.getGlobalBounds().intersects(RECT))
        return true;
    return false;
}

sf::Vector2f Ball::getBallPosition()
{
    return Object.getPosition();
}

float Ball::getBallRadius()
{
    return Object.getRadius();
}

void Ball::move()
{
    Object.move(currentSpeed.x, currentSpeed.y);
}

sf::CircleShape Ball::getObject()
{
    return Object;
}

Ball::~Ball()
{
}
