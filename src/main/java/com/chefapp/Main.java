package com.chefapp;

import com.chefapp.repository.SaladRepository;
import com.chefapp.repository.VegetableRepository;
import com.chefapp.repository.impl.SaladRepositoryListImpl;
import com.chefapp.repository.impl.VegetableRepositoryListImpl;
import com.chefapp.service.SaladService;
import com.chefapp.service.VegetableService;
import com.chefapp.service.impl.SaladServiceImpl;
import com.chefapp.service.impl.VegetableServiceImpl;
import com.chefapp.ui.ConsoleApplication;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        SaladRepository saladRepository = new SaladRepositoryListImpl(new ArrayList<>());
        VegetableRepository vegetableRepository = new VegetableRepositoryListImpl(new ArrayList<>());
        SaladService saladService = new SaladServiceImpl(saladRepository);
        VegetableService vegetableService = new VegetableServiceImpl(vegetableRepository);

        ConsoleApplication application = new ConsoleApplication(saladService,vegetableService);
        application.run();

    }
}
