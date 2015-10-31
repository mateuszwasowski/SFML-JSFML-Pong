#ifndef UTILTEXT_H
#define UTILTEXT_H

#include <SFML/Graphics.hpp>
#include <string>

class UtilText
{
public:
    UtilText(std::string str);
    void setText(int a, int b, int c, sf::Color color);
    sf::Text getObject();
    void setString( std::string s);
protected:
private:
    sf::Text Tekst;
    sf::Font font;
};

#endif // UTILTEXT_H
