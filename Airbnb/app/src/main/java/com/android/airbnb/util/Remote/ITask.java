package com.android.airbnb.util.Remote;

import com.android.airbnb.domain.airbnb.Host;
import com.android.airbnb.domain.airbnb.House;
import com.android.airbnb.domain.reservation.Reservation;

import java.util.List;

/**
 * Created by JunHee on 2017. 8. 3..
 */

public interface ITask {

    public interface totalHouseList{
        public void doTotalHouseList(List<House> houseList);
    }

    public interface totalHostList{
        public void doTotalHostList(List<Host> hostList);
    }

    public interface oneHouseList{
        public void doOneHouseList(House house);
    }

    public interface oneHostList{
        public void doOneHostList(Host host);
    }

    public interface oneReservation{
        public void doOneReservation(List<Reservation> reservations);
    }

    public interface allWishList{
        public void doAllWishList(List<House> houses);
    }

    public interface postWishList{
        public void getResponse(String message);
    }

    /*
    public void doTaskTotalHostList(List<Host> hostList);
    public void doTaskTotalHouseList(List<House> houseList);
    public void doTaskOneHouseList(House house);
    public void doTaskOneHostList(Host host);
    */
}


