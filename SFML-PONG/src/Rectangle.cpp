#include "../include/Rectangle.h"

Rectangle::Rectangle(int WIDTH, int HEIGHT, sf::Color COLOR)
{
    Object.setSize(sf::Vector2f(WIDTH, HEIGHT));
    Object.setFillColor(COLOR);
}

sf::RectangleShape Rectangle::getObject()
{
    return Object;
};

void Rectangle::setColor( sf::Color color)
{
    Object.setFillColor(color);
};


void Rectangle::setPosition(sf::Vector2f POSITION)
{
    Object.setPosition(POSITION);
}


bool Rectangle::touches(sf::RectangleShape RECTANGLE)
{
    if(Object.getGlobalBounds().intersects(RECTANGLE.getGlobalBounds()))
        return true;
    return false;
}

sf::Vector2f Rectangle::getPosition()
{
    return Object.getPosition();
}

sf::Vector2f Rectangle::getSize()
{
    return Object.getSize();
}

Rectangle::~Rectangle()
{

}
