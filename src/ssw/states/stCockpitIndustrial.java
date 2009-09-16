/*
Copyright (c) 2008~2009, Justin R. Bengtson (poopshotgun@yahoo.com)
All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted provided that the following conditions are met:

    * Redistributions of source code must retain the above copyright notice,
        this list of conditions and the following disclaimer.
    * Redistributions in binary form must reproduce the above copyright notice,
        this list of conditions and the following disclaimer in the
        documentation and/or other materials provided with the distribution.
    * Neither the name of Justin R. Bengtson nor the names of contributors may
        be used to endorse or promote products derived from this software
        without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

package ssw.states;

import ssw.Constants;
import ssw.components.AvailableCode;
import ssw.components.LocationIndex;
import ssw.components.MechModifier;
import ssw.components.SimplePlaceable;

public class stCockpitIndustrial implements ifCockpit, ifState {
    private final static AvailableCode AC = new AvailableCode( AvailableCode.TECH_BOTH );
    private final static SimplePlaceable Sensors = new SimplePlaceable( "Sensors", "Sensors", "Sensors", "Sensors", "Tech Manual", 1, true, AC );
    private final static SimplePlaceable LifeSupport = new SimplePlaceable( "Life Support", "Life Support", "Life Support", "Life Support", "Tech Manual", 1, true, AC );
    private final static SimplePlaceable SecondSensors = new SimplePlaceable( "Sensors", "Sensors", "Sensors", "Sensors", "Tech Manual", 1, true, AC );
    private final static SimplePlaceable SecondLifeSupport = new SimplePlaceable( "Life Support", "Life Support", "Life Support", "Life Support", "Tech Manual", 1, true, AC );

    public stCockpitIndustrial() {
        AC.SetISCodes( 'C', 'B', 'C', 'C' );
        AC.SetISDates( 0, 0, false, 2300, 0, 0, false, false );
        AC.SetISFactions( "", "", "TH", "" );
        AC.SetCLCodes( 'C', 'X', 'C', 'C' );
        AC.SetCLDates( 0, 0, false, 2300, 0, 0, false, false );
        AC.SetCLFactions( "", "", "TH", "" );
        AC.SetRulesLevels( AvailableCode.RULES_UNALLOWED, AvailableCode.RULES_TOURNAMENT, AvailableCode.RULES_UNALLOWED, AvailableCode.RULES_UNALLOWED, AvailableCode.RULES_UNALLOWED );
    }

    public boolean HasCounterpart() {
        return false;
    }

    public double GetTonnage() {
        double result = 3.0f;
        result += Sensors.GetTonnage();
        result += SecondSensors.GetTonnage();
        result += LifeSupport.GetTonnage();
        result += SecondLifeSupport.GetTonnage();
        return result;
    }

    public boolean HasSecondLSLoc() {
        return true;
    }
    
    public SimplePlaceable GetLifeSupport() {
        return LifeSupport;
    }
    
    public SimplePlaceable GetSensors() {
        return Sensors;
    }

    public SimplePlaceable GetSecondLifeSupport() {
        return SecondLifeSupport;
    }
    
    public SimplePlaceable GetSecondSensors() {
        return SecondSensors;
    }

    public String ActualName() {
        return "Industrial Cockpit";
    }

    public String CritName() {
        return "Cockpit";
    }

    public String LookupName() {
        return "Industrial Cockpit";
    }

    public String ChatName() {
        return "Ind Cockpit";
    }

    public String MegaMekName( boolean UseRear ) {
        return "Cockpit";
    }

    public String BookReference() {
        return "Tech Manual";
    }

    public String GetReportName() {
        return "Industrial";
    }

    public double GetCost( int Tonnage ) {
        double result = 150000.0f + ( 2000.0f * Tonnage );
        result += Sensors.GetCost();
        result += LifeSupport.GetCost();
        result += SecondSensors.GetCost();
        result += SecondLifeSupport.GetCost();
        return result;
    }

    public boolean HasFireControl() {
        return false;
    }

    public double BVMod() {
        return 0.9f;
    }

    public AvailableCode GetAvailability() {
        return AC;
    }
    
    public int ReportCrits() {
        return 5;
    }

    public MechModifier GetMechModifier() {
        return null;
    }

    @Override
    public String toString() {
        return "Industrial Cockpit";
    }

    public LocationIndex GetCockpitLoc() {
        return new LocationIndex( 2, Constants.LOC_HD, -1 );
    }

    public LocationIndex GetFirstSensorLoc() {
        return new LocationIndex( 1, Constants.LOC_HD, -1 );
    }

    public LocationIndex GetSecondSensorLoc() {
        return new LocationIndex( 4, Constants.LOC_HD, -1 );
    }

    public LocationIndex GetFirstLSLoc() {
        return new LocationIndex( 0, Constants.LOC_HD, -1 );
    }

    public LocationIndex GetSecondLSLoc() {
        return new LocationIndex( 5, Constants.LOC_HD, -1 );
    }

    public boolean CanUseCommandConsole() {
        return true;
    }

    public boolean HasThirdSensors() {
        return false;
    }

    public LocationIndex GetThirdSensorLoc() {
        return null;
    }

    public SimplePlaceable GetThirdSensors() {
        return null;
    }

    public boolean IsTorsoMounted() {
        return false;
    }
}
