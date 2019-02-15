package com.spartronics4915.frc2019;

import com.spartronics4915.frc2019.controlboard.*;
import com.spartronics4915.lib.util.Logger;

import edu.wpi.first.wpilibj.Joystick;

public class ControlBoard implements IControlBoard
{

    private IDriveControlBoard mDriveControlBoard;
    private IButtonControlBoard mButtonControlBoard;

    public ControlBoard()
    {
        // Possibly use Joystick::getType instead of Joystick::getName
        String joyName = new Joystick(Constants.kDriveJoystickPort).getName();
        switch (joyName)
        {
            case "Controller (Xbox One For Windows)": // Names of joysticks are the same as the names in the driver station program
                mDriveControlBoard = new XboxSplitControlBoard();
                break;
            case "Logitech Attack 3":
                if (new Joystick(3).getName().equals("Logitech Attack 3"))
                    mDriveControlBoard = new TwoJoystickSplitControlBoard();
                else
                    mDriveControlBoard = new OneJoystickControlBoard();
                break;
            default:
                mDriveControlBoard = new OneJoystickControlBoard();
                break;
        }
        Logger.notice("Found joystick " + joyName + " on port 0, selected IControlBoard implementer " + mDriveControlBoard.getClass().getName());

        mButtonControlBoard = new MainButtonBoard();
    }

    @Override
    public double getThrottle()
    {
        return mDriveControlBoard.getThrottle();
    }

    @Override
    public double getTurn()
    {
        return mDriveControlBoard.getTurn();
    }

    @Override
    public boolean getQuickTurn()
    {
        return mDriveControlBoard.getQuickTurn();
    }

    @Override
    public boolean getReturnToDriverControl()
    {
        return mDriveControlBoard.getReturnToDriverControl();
    }

    @Override
    public boolean getReverseDirection()
    {
        return mDriveControlBoard.getReverseDirection();
    }

    @Override
    public boolean getDriveToSelectedTarget()
    {
        return mDriveControlBoard.getDriveToSelectedTarget();
    }

    @Override
    public boolean getTestButtonOne()
    {
        return mDriveControlBoard.getTestButtonOne();
    }

    @Override
    public boolean getTestButtonTwo()
    {
        return mDriveControlBoard.getTestButtonTwo();
    }

    @Override
    public boolean getTestButtonThree()
    {
        return mDriveControlBoard.getTestButtonThree();
    }

    //ButtonBoard

    @Override
    public boolean getClimb()
    {
        return mButtonControlBoard.getClimb();
    }

    @Override
    public boolean getManualExtendAllClimbPneumatics()
    {
        return mButtonControlBoard.getManualExtendAllClimbPneumatics();
    }

    @Override
    public boolean getAssistedIntakeCargo()
    {
        return mButtonControlBoard.getAssistedIntakeCargo();
    }

    @Override
    public boolean getGroundEjectCargo()
    {
        return mButtonControlBoard.getGroundEjectCargo();
    }

    @Override
    public boolean getManualRamp()
    {
        return mButtonControlBoard.getManualRamp();
    }

    @Override
    public boolean getAssistedShootRocket()
    {
        return mButtonControlBoard.getAssistedShootRocket();
    }

    @Override
    public boolean getAssistedShootBay()
    {
        return mButtonControlBoard.getAssistedShootBay();
    }

    @Override
    public boolean getManualShootCargo()
    {
        return mButtonControlBoard.getManualShootCargo();
    }

    @Override
    public boolean getManualChuteUp()
    {
        return mButtonControlBoard.getManualChuteUp();
    }

    @Override
    public boolean getManualChuteDown()
    {
        return mButtonControlBoard.getManualChuteDown();
    }

    @Override
    public boolean getAssistedIntakePanel()
    {
        return mButtonControlBoard.getAssistedIntakePanel();
    }

    @Override
    public boolean getAssistedEjectPanel()
    {
        return mButtonControlBoard.getAssistedEjectPanel();
    }

    @Override
    public boolean getManualEjectPanel()
    {
        return mButtonControlBoard.getManualEjectPanel();
    }

    @Override
    public boolean getInsideFramePerimeter()
    {
        return mButtonControlBoard.getInsideFramePerimeter();
    }
}
