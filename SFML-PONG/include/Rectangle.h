#ifndef RECTANGLE_H
#define RECTANGLE_H


#include <SFML/Graphics.hpp>

class Rectangle
{
protected:
    sf::RectangleShape Object;

public:


    //Konstruktor
    Rectangle(int WIDTH, int HEIGHT, sf::Color COLOR);

    // set position
    void setPosition(sf::Vector2f POSITION);

    void setColor( sf::Color color);

    // sprawdza czy dwa obiekty sie dotykaja
    bool touches(sf::RectangleShape RECTANGLE);

    sf::Vector2f getPosition();

    sf::Vector2f getSize();

    sf::RectangleShape getObject();

    // destruktor
    ~Rectangle();
};

#endif // RECTANGLE_H
