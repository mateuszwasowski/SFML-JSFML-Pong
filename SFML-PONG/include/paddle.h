#ifndef PADDLE_H
#define PADDLE_H

#include "../include/Rectangle.h"


class Paddle : public Rectangle
{
public:
    Paddle(int WIDTH, int HEIGHT, sf::Color COLOR);
    ~Paddle();
    void goUp();
    void goDown();

};

#endif // PADDLE_H
