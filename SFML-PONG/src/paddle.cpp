#include "../include/Paddle.h"

Paddle::Paddle(int WIDTH, int HEIGHT, sf::Color COLOR):
    Rectangle(WIDTH,HEIGHT,COLOR)
{
    //ctor
}

Paddle::~Paddle()
{
    //dtor
}

void Paddle::goUp()
{

    Object.move(0, -0.20);
}

void Paddle::goDown()
{

    Object.move(0, 0.20);
}
