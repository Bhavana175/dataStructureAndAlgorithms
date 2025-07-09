package lld.splitwise;

import lld.splitwise.controller.BalanceSheetController;
import lld.splitwise.controller.ExpenseController;
import lld.splitwise.controller.GroupController;
import lld.splitwise.controller.UserController;
import lld.splitwise.model.Split;
import lld.splitwise.model.SplitType;
import lld.splitwise.model.User;
import lld.splitwise.service.Group;

import java.util.ArrayList;
import java.util.List;

public class SplitWise {

    UserController userController;
    GroupController groupController;
    BalanceSheetController balanceSheetController;

    public SplitWise() {
        this.userController = new UserController();
        this.groupController = new GroupController();
        this.balanceSheetController = new BalanceSheetController();
    }
    public void demo(){

        addUserToSplitWiseApp();
        setUpUsersAndGroup();

        List<Split> splitDetails = new ArrayList<>();
        Split split1 = new Split(userController.getUser("U1001"), 300.0);
        Split split2 = new Split(userController.getUser("U1002"), 300.0);
        Split split3 = new Split(userController.getUser("U1003"), 300.0);
        splitDetails.add(split1);
        splitDetails.add(split2);
        splitDetails.add(split3);

        Group group = groupController.getGroupById("G1001");
        group.createExpense("Exp1001", "Breakfast", 900, splitDetails, SplitType.EQUAL, userController.getUser("U1001"));

        balanceSheetController.showBalanceSheetOfUser(userController.getUser("U1001"));

        ExpenseController expenseController = new ExpenseController();
        splitDetails.clear();
        Split split4 = new Split(userController.getUser("U1001"), 300.0);
        Split split5 = new Split(userController.getUser("U1002"), 300.0);
        splitDetails.add(split4);
        splitDetails.add(split5);
        expenseController.createExpense("Exp1002", "Chocolate", userController.getUser("U1002"),
                600,  SplitType.EQUAL, splitDetails );
        System.out.println("------------");
        balanceSheetController.showBalanceSheetOfUser(userController.getUser("U1001"));
        System.out.println("------------");
        balanceSheetController.showBalanceSheetOfUser(userController.getUser("U1002"));
        System.out.println("------------");
        balanceSheetController.showBalanceSheetOfUser(userController.getUser("U1003"));
    }

    public void addUserToSplitWiseApp(){

        User user1 = new User("U1001", "A", "a@gmail.com");
        User user2 = new User("U1002", "B", "b@gmail.com");
        User user3 = new User("U1003", "C", "c@gmail.com");

        this.userController.addUser(user1);
        this.userController.addUser(user2);
        this.userController.addUser(user3);
    }

    public void setUpUsersAndGroup(){
        groupController.createNewGroup("G1001", "clgGroup", userController.getUser("U1001"));
        Group group = groupController.getGroupById("G1001");
        group.addMember(userController.getUser("U1002"));
        group.addMember(userController.getUser("U1003"));
    }



}
