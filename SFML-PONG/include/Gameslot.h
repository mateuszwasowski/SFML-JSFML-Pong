#ifndef GAMESLOT_H
#define GAMESLOT_H

#include <string>
#include <fstream>



class Gameslot
{
    public:
        Gameslot(std::string n);
        void open();
        void close();
        void save(std::string time, int p1scor , int p2scor);

    private:
        std::string name;
        std::fstream account;

};

#endif // GAMESLOT_H
