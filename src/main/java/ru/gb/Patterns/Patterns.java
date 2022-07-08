package ru.gb.Patterns;

import ru.gb.Patterns.Builder.Director;
import ru.gb.Patterns.Builder.HeavyIndustrialUnitBuilder;
import ru.gb.Patterns.Builder.IndustrialUnit;
import ru.gb.Patterns.Builder.LightIndustrialUnitBuilder;
import ru.gb.Patterns.EasyBuilder.Report;
import ru.gb.Patterns.Factory.*;
import ru.gb.Patterns.Mediator.ConcreteMediator;
import ru.gb.Patterns.Mediator.ConcreteTaxi;
import ru.gb.Patterns.Mediator.Trip;
import ru.gb.Patterns.Observer.Document;
import ru.gb.Patterns.Observer.Person;
import ru.gb.Patterns.Singleton.LimitedMultiton;
import ru.gb.Patterns.Singleton.Multiton;
import ru.gb.Patterns.Singleton.Singleton;
import ru.gb.Patterns.State.Phone;
import ru.gb.Patterns.Strategy.FixedDiscount;
import ru.gb.Patterns.Strategy.PercentDiscount;
import ru.gb.Patterns.Strategy.Product;
import ru.gb.Patterns.Strategy.ShoppingCart;
import ru.gb.Patterns.Visitor.*;
import ru.gb.Patterns.chainsOfResponsibility.MoneyTransfer;
import ru.gb.Patterns.chainsOfResponsibility.TransferManager;

import java.math.BigDecimal;

public class Patterns {

    public static void main(String[] args) {


        /***** Singleton & Multiton *****/

        System.out.println("\n*********** Singleton ***********");
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println("Singleton 1 - " + singleton1);
        System.out.println("Singleton 2 - " + singleton2);

        System.out.println("\n*********** Multiton ***********");
        Multiton multiton1 = Multiton.getInstance("1");
        Multiton multiton2 = Multiton.getInstance("2");
        Multiton multiton3 = Multiton.getInstance("2");
        System.out.println(multiton1);
        System.out.println(multiton2);
        System.out.println(multiton3);

        System.out.println("\n*********** Limited Multiton ***********");
        LimitedMultiton limitedMultiton1 = LimitedMultiton.getInstance(LimitedMultiton.Count.ONE);
        LimitedMultiton limitedMultiton2 = LimitedMultiton.getInstance(LimitedMultiton.Count.TWO);
        LimitedMultiton limitedMultiton3 = LimitedMultiton.getInstance(LimitedMultiton.Count.THREE);
        LimitedMultiton limitedMultiton4 = LimitedMultiton.getInstance(LimitedMultiton.Count.THREE);
        System.out.println(limitedMultiton1);
        System.out.println(limitedMultiton2);
        System.out.println(limitedMultiton3);
        System.out.println(limitedMultiton4);


        /***** Фабрика обьектов / FactoryMethod *****/

        System.out.println("\n*********** FactoryMethod ***********");
        Store store = new GroceryStore();
        store.saleGood();

        StoreFactory storeFactory = new GroceryStoreFactory();
        Store storeGrocery = storeFactory.createStore();
        storeGrocery.saleGood();

        StoreFactory storeFactoryWear = new WearStoreFactory();
        Store storeWear = storeFactoryWear.createStore();
        storeWear.saleGood();


        /***** Строитель / Builder *****/
        System.out.println("\n*********** Builder ***********");
        Director director = new Director();
        director.setBuilder(new LightIndustrialUnitBuilder());
        IndustrialUnit industrialUnit = director.buildIndustrialUnit();
        System.out.println(industrialUnit);

        director.setBuilder(new HeavyIndustrialUnitBuilder());
        System.out.println(director.buildIndustrialUnit());

        /***** Строитель в одном классе / EasyBuilder *****/
        System.out.println("\n*********** EasyBuilder ***********");
        Report report = new Report.Builder("Отчет за 1 квартал 2022")
                .setTitle("Закупка")
                .setContent("Реализовано успешно")
                .setTable("Таблица цен")
                .setPageNumber(1)
                .build();

        System.out.println(report);
        System.out.println(report.getHeader());
        System.out.println(report.getContent());

        /***** Визитер / Visitor *****/

        /**
         * Ситуации, когда пригодиться Visitor - это когда у нас есть некое множество похожих классов,
         * например Студент, Препод, Декан, Ректор, Бухгалтерша, Техничка, Лаборант и т.д. - они все разные,
         * но все огут быть унаследованы от одного класса, например Персона, ии вот во всех этих классах
         * надо реализовать методы, которые есть у всех, Например показать инф. в текстовой форме, в форме XML и тд,
         * но вынести в родительский класс мы их не можем, т.к. у всех они реализованы по своему. Причем колличество
         * таких методов тоже стремиться к увеличению.
         * Вот тут приходит на помощь Visitor. Суть в том, что во первых: мы создаем абстрактный класс Visitor,
         * где обьявляем метод ShowInfo с параметром каждого дочернего класса Персон (перегрузка),
         * во вторых: создаем классы, аналогичные методам в классах наследниках Персон, то есть TextVisitor, XmlVisitor
         * и т.д. Все визитеры унаследованы от абстрактоного Visitor и соответственно содержат в себе метод ShowInfo
         * с реализацией для каждого класса. В третьих в класс Person мы добавляем метод (например Visit) с параметром Visitor visitor,
         * а в дочерних реализуем его с логикой visitor.showInfo(this). Таким образом сетка методов/бъектов закрывается.
         * Работает так:
         * у любого обьекта мы можем вызвать метод Visit с параметром того визитера, какой метод нам нужен,
         * метод Visit переопределен в каждом классе, где вызывается метод showInfo с параметром This у того визитера,
         * который передан в параметрах на вход. Всё.
         */
        System.out.println("\n*********** Visitor ***********");
        Student vasa = new Student();
        vasa.name = "Вася";
        vasa.lastname = "Пупкин";
        vasa.groupId = 100;

        Teacher arkadiy = new Teacher();
        arkadiy.name = "Аркадий";
        arkadiy.lastname = "Паровозов";
        arkadiy.totalGroup = 4;

        School school = new School();
        school.addPerson(vasa);
        school.addPerson(arkadiy);

        XmlPersonVisitor xml = new XmlPersonVisitor();
        TextPersonVisitor txt = new TextPersonVisitor();
        school.Accept(xml);
        school.Accept(txt);


        /*************** https://metanit.com/ *****************/

        /***** Наблюдатель / Observer *****/
        System.out.println("\n*********** Observer ***********");

        Person personReviewer = new Person();
        personReviewer.Id = 1;
        personReviewer.name = "Корректор";

        Person personAuthor = new Person();
        personAuthor.Id = 2;
        personAuthor.name = "Автор";

        Person personCommentator = new Person();
        personCommentator.Id = 3;
        personCommentator.name = "Комментатор";

        Document document = new Document("Привет Мир!");
        document.addSubscriber(personAuthor);
        document.addSubscriber(personReviewer);
        document.addSubscriber(personCommentator);

        document.addText("ddd");


        /***** Цепочка обязанностей / Chains of Responsibility *****/
        System.out.println("\n*********** Chains of Responsibility ***********");

        /**
         * Идеально подойдет там, где большая цепочка условий и какой-то логики по этим условиям
         * типа if-else if, а также switch-case.
         * Смысл паттерна в том, чтобы каждый else if вынести в отдельный класс, который содержит 2 метода:
         * CanDo - условие, когда метод выполняется и Do - что именно выполняется, все эти классы унаследованы от
         * родительского абстрактного Middleware.
         * Работает это всё так:
         * 1) создаем какой-то класс типа Manager, в методе которого вместо цепочки else if мы создаем объект,
         * наследник Middleware (любой, например с которого бы мы начали if), в параметрах создаем новый объект
         * и так далее до последнего. В параметрах последнего передаем null.
         * 2) Вызываем у этого объекта метод process.
         * Происходит следующее: process - метод родительского класса. В конструкторе Middleware мы получаем и сохраняем
         * ссылку на следующий объект Middleware, в методе process логика простая -
         * 1) если CanDo == true, то запускаем Do,
         * 2) если ссылка на следующий объект не пуста, то запускаем метод process у следующего объекта.
         * Методы Do и CanDo переопределены у каждого наследника Middleware. Это позволяет индивидуально разбираться
         * с каждой логикой без учета прочей цепочки условий, что делает код более надежным и удобным для работы.
         */

        MoneyTransfer transfer = new MoneyTransfer();
        transfer.currency = "RUB";
        transfer.money = 100.0;
        transfer.fromAccount = "RZB 0984351451435435";
        transfer.toAccount = "ALF 0985861451432145";
        transfer.provider = "B2B";

        TransferManager manager = new TransferManager();
        manager.doTransfer(transfer);

        MoneyTransfer newTransfer = new MoneyTransfer();
        newTransfer.currency = "RUB";
        newTransfer.money = 1000.0;
        newTransfer.fromAccount = "RZB 0984351451435435";
        newTransfer.toAccount = "ALF 0985861451432145";
        newTransfer.provider = "B2P";

        manager.doTransfer(newTransfer);

        /***** Mediator / Посредник *****/
        System.out.println("\n*********** Mediator ***********");

        ConcreteMediator mediator = new ConcreteMediator();
        ConcreteTaxi taxi1 = new ConcreteTaxi("Driver 1", "Free", false, mediator);
        ConcreteTaxi taxi2 = new ConcreteTaxi("Driver 2", "Free", false, mediator);
        ConcreteTaxi taxi3 = new ConcreteTaxi("Driver 3", "Free", false, mediator);
        ConcreteTaxi taxi4 = new ConcreteTaxi("Driver 4", "Free", false, mediator);
        ConcreteTaxi taxi5 = new ConcreteTaxi("Driver 5", "Free", false, mediator);

        mediator.add(taxi1);
        mediator.add(taxi2);
        mediator.add(taxi3);
        mediator.add(taxi4);
        mediator.add(taxi5);

        Trip trip1 = new Trip(false, "Address 1");
        Trip trip2 = new Trip(false, "Address 2");
        Trip trip3 = new Trip(false, "Address 3");
        Trip trip4 = new Trip(false, "Address 4");
        Trip trip5 = new Trip(false, "Address 5");
        Trip trip6 = new Trip(false, "Address 6");
        taxi1.assingDriver(trip1);
        taxi3.assingDriver(trip2);
        taxi1.assingDriver(trip3);
        taxi5.assingDriver(trip4);
        taxi2.assingDriver(trip6);
        taxi2.assingDriver(trip5);
        taxi3.setFree();
        taxi2.assingDriver(trip5);


        /***** Strategy / Стратегия *****/
        System.out.println("\n*********** Strategy ***********");

        Product product = new Product(1L, "Product 1", new BigDecimal(100));
        ShoppingCart cart = new ShoppingCart();
        cart.setDiscountable(new PercentDiscount(new BigDecimal("0.1")));
//        cart.setDiscountable(new FixedDiscount(new BigDecimal("0.1")));
        cart.addToCart(product);
        System.out.println("Total = " + cart.calcTotal());


        /***** State / Состояние *****/
        System.out.println("\n*********** State ***********");

        Phone phone = new Phone();
        for (int i = 0; i < 10; i++) {
            System.out.println(phone.getState());
            phone.switchState();
        }

    }
}
