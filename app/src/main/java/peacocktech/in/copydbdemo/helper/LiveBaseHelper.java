package peacocktech.in.copydbdemo.helper;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import peacocktech.in.copydbdemo.model.Bincmast;
import peacocktech.in.copydbdemo.model.Brnmast;
import peacocktech.in.copydbdemo.model.Colmast;
import peacocktech.in.copydbdemo.model.Cutmast;
import peacocktech.in.copydbdemo.model.Flomast;
import peacocktech.in.copydbdemo.model.Qualitymast;
import peacocktech.in.copydbdemo.model.RateMixmast;
import peacocktech.in.copydbdemo.model.Sbincmast;
import peacocktech.in.copydbdemo.model.Shapmast;
import peacocktech.in.copydbdemo.model.Sincmast;
import peacocktech.in.copydbdemo.model.SizeSrksizeIpadcpsmast;
import peacocktech.in.copydbdemo.model.Symmast;
import peacocktech.in.copydbdemo.model.Tensionmast;
import peacocktech.in.copydbdemo.model.Tincmast;

/**
 * Created by peacock on 14/10/17.
 */

public class LiveBaseHelper extends SQLiteOpenHelper {

    //The Android's default system path of your application database.
    private static String DB_PATH = "/data/data/peacocktech.in.copydbdemo/databases/";
    private static String DB_NAME = "rapdatapeacock.db";
    private final Context myContext;
    private SQLiteDatabase myDataBase;
    private boolean isassets;
    private String path = "";


    /**
     * Constructor
     * Takes and keeps a reference of the passed context in order to access to the application assets and resources.
     *
     * @param context
     */
    public LiveBaseHelper(Context context, boolean isAssets, String url) {
        super(context, DB_NAME, null, 1);
        this.myContext = context;
        this.isassets = isAssets;
        this.path = url;
        try {

            createDataBase();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates a empty database on the system and rewrites it with your own database.
     */
    public void createDataBase() throws IOException {

        boolean dbExist = checkDataBase();

        if (dbExist) {
            //do nothing - database already exist


        } else {

            //By calling this method and empty database will be created into the default system path
            //of your application so we are gonna be able to overwrite that database with our database.
            this.getWritableDatabase();

            try {

                copyDataBase();

            } catch (IOException e) {

                throw new Error("Error copying database");

            }
        }
    }

    /**
     * Check if the database already exist to avoid re-copying the file each time you open the application.
     *
     * @return true if it exists, false if it doesn't
     */
    public boolean checkDataBase() {


        String myPath = DB_PATH + DB_NAME;
        File file = new File(myPath);


        return file.exists();
    }

    /**
     * Copies your database from your local assets-folder to the just created empty database in the
     * system folder, from where it can be accessed and handled.
     * This is done by transfering bytestream.
     */
    private void copyDataBase() throws IOException {
        InputStream myInput=null;

        if (isassets == true) {
             myInput = myContext.getAssets().open("database/" + DB_NAME);
        } else {
             myInput = new FileInputStream(new File(path));
        }
        String outFileName = DB_PATH + DB_NAME;
        OutputStream myOutput = new FileOutputStream(outFileName);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }

        //Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();

        Toast.makeText(myContext, "DBCREATED", Toast.LENGTH_LONG).show();

    }

    public void openDataBase() {

        //Open the database
        try {
            String myPath = DB_PATH + DB_NAME;
            myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public synchronized void close() {

        if (myDataBase != null)
            myDataBase.close();

        super.close();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

/* ========================================================================================================================================
    All Querys
*/

    /*ShapList*/
    public ArrayList<Shapmast> getallshaplist() {
        ArrayList<Shapmast> shapdata = new ArrayList<Shapmast>();
        openDataBase();
        Cursor c1 = myDataBase.rawQuery("SELECT * FROM  " + "DATA_SHPMAST", null);
        Log.e("DATA_SHPMAST", String.valueOf(c1.getColumnCount()));
        if (null != c1) {
            if (c1.moveToFirst()) {
                do {
                    Shapmast shap = new Shapmast();
                    shap.setScode(c1.getString(c1.getColumnIndex("S_CODE")));
                    shap.setSname(c1.getString(c1.getColumnIndex("S_NAME")));
                    shap.setSsortname(c1.getString(c1.getColumnIndex("S_SORTNAME")));
                    shap.setSscode(c1.getString(c1.getColumnIndex("SS_CODE")));
                    shap.setImagename(c1.getString(c1.getColumnIndex("IMG_NAME")));
                    if (c1.getPosition() == 0) {
                        shap.setSelection(true);
                    } else {
                        shap.setSelection(false);
                    }
                    shapdata.add(shap);
                } while (c1.moveToNext());
            }
        }
        c1.close();
        close();
        return shapdata;
    }

    /*ColorList*/
    public ArrayList<Colmast> getallcolorlist() {
        ArrayList<Colmast> colordata = new ArrayList<Colmast>();
        openDataBase();
        Cursor c1 = myDataBase.rawQuery("SELECT * FROM  " + "DATA_COLMAST", null);
        Log.e("DATA_COLMAST", String.valueOf(c1.getColumnCount()));
        if (null != c1) {
            if (c1.moveToFirst()) {
                do {
                    Colmast colors = new Colmast();
                    colors.setCcode(c1.getString(c1.getColumnIndex("C_CODE")));
                    colors.setCname(c1.getString(c1.getColumnIndex("C_NAME")));
                    colordata.add(colors);
                } while (c1.moveToNext());
            }
        }
        c1.close();
        close();
        return colordata;
    }


    /*Qualitymast*/
    public ArrayList<Qualitymast> getallqualitylist() {
        ArrayList<Qualitymast> qualitydata = new ArrayList<Qualitymast>();
        openDataBase();
        Cursor c1 = myDataBase.rawQuery("SELECT * FROM  " + "DATA_QUAMAST", null);
        Log.e("DATA_QUAMAST", String.valueOf(c1.getColumnCount()));
        if (null != c1) {
            if (c1.moveToFirst()) {
                do {
                    Qualitymast qualitymast = new Qualitymast();
                    qualitymast.setQcode(c1.getString(c1.getColumnIndex("Q_CODE")));
                    qualitymast.setQname(c1.getString(c1.getColumnIndex("Q_NAME")));
                    qualitydata.add(qualitymast);
                } while (c1.moveToNext());
            }
        }
        c1.close();
        close();
        return qualitydata;
    }


    /*Cutlist*/
    public ArrayList<Cutmast> getallcutlist() {
        ArrayList<Cutmast> cutdata = new ArrayList<Cutmast>();
        openDataBase();
        Cursor c1 = myDataBase.rawQuery("SELECT * FROM  " + "DATA_CUTMAST", null);
        Log.e("DATA_CUTMAST", String.valueOf(c1.getColumnCount()));
        if (null != c1) {
            if (c1.moveToFirst()) {
                do {
                    Cutmast cutmast = new Cutmast();
                    cutmast.setCtcode(c1.getString(c1.getColumnIndex("CT_CODE")));
                    cutmast.setCtname(c1.getString(c1.getColumnIndex("CT_NAME")));
                    cutmast.setSortname(c1.getString(c1.getColumnIndex("SORTNAME")));
                    cutdata.add(cutmast);
                } while (c1.moveToNext());
            }
        }
        c1.close();
        close();
        return cutdata;
    }

    /*Symlist*/
    public ArrayList<Symmast> getallsymlist() {
        ArrayList<Symmast> symdata = new ArrayList<Symmast>();
        openDataBase();
        Cursor c1 = myDataBase.rawQuery("SELECT * FROM  " + "DATA_SYMMAST", null);
        Log.e("DATA_SYMMAST", String.valueOf(c1.getColumnCount()));
        if (null != c1) {
            if (c1.moveToFirst()) {
                do {
                    Symmast symmast = new Symmast();
                    symmast.setSycode(c1.getString(c1.getColumnIndex("SY_CODE")));
                    symmast.setSyname(c1.getString(c1.getColumnIndex("SY_NAME")));
                    symmast.setSysortname(c1.getString(c1.getColumnIndex("SORTNAME")));
                    symdata.add(symmast);
                } while (c1.moveToNext());
            }
        }
        c1.close();
        close();
        return symdata;
    }

    /*Flolist*/
    public ArrayList<Flomast> getallFlolist() {
        ArrayList<Flomast> flodata = new ArrayList<Flomast>();
        openDataBase();
        Cursor c1 = myDataBase.rawQuery("SELECT * FROM  " + "DATA_FLOMAST", null);
        Log.e("DATA_FLOMAST", String.valueOf(c1.getColumnCount()));
        if (null != c1) {
            if (c1.moveToFirst()) {
                do {
                    Flomast flomast = new Flomast();
                    flomast.setFlcode(c1.getString(c1.getColumnIndex("FL_CODE")));
                    flomast.setFlname(c1.getString(c1.getColumnIndex("FL_NAME")));
                    flomast.setFlsortname(c1.getString(c1.getColumnIndex("SORTNAME")));
                    flodata.add(flomast);
                } while (c1.moveToNext());
            }
        }
        c1.close();
        close();
        return flodata;
    }


    /*Tinclist*/
    public ArrayList<Tincmast> getalltinclist() {
        ArrayList<Tincmast> tincdata = new ArrayList<Tincmast>();
        openDataBase();
        Cursor c1 = myDataBase.rawQuery("SELECT * FROM  " + "DATA_TINCMAST", null);

        Log.e("DATA_TINCMAST", String.valueOf(c1.getColumnCount()));
        if (null != c1) {
            if (c1.moveToFirst()) {
                do {
                    Tincmast tincmast = new Tincmast();
                    tincmast.setTincode(c1.getString(c1.getColumnIndex("TIN_CODE")));
                    tincmast.setTinname(c1.getString(c1.getColumnIndex("TIN_NAME")));
                    tincmast.setSortname(c1.getString(c1.getColumnIndex("SORTNAME")));
                    tincmast.setTincaption(c1.getString(c1.getColumnIndex("TIN_CAPTION")));
                    tincdata.add(tincmast);
                } while (c1.moveToNext());
            }
        }
        c1.close();
        close();
        return tincdata;
    }


    /*Sinclist*/
    public ArrayList<Sincmast> getallsinclist() {
        ArrayList<Sincmast> sincdata = new ArrayList<Sincmast>();
        openDataBase();
        Cursor c1 = myDataBase.rawQuery("SELECT * FROM  " + "DATA_SINCMAST", null);
        Log.e("DATA_SINCMAST", String.valueOf(c1.getColumnCount()));
        if (null != c1) {
            if (c1.moveToFirst()) {
                do {
                    Sincmast sincmast = new Sincmast();
                    sincmast.setSortname(c1.getString(c1.getColumnIndex("SORTNAME")));
                    sincmast.setSincode(c1.getString(c1.getColumnIndex("SIN_CODE")));
                    sincmast.setSinname(c1.getString(c1.getColumnIndex("SIN_NAME")));
                    sincmast.setSincaption(c1.getString(c1.getColumnIndex("SIN_CAPTION")));
                    sincdata.add(sincmast);
                } while (c1.moveToNext());
            }
        }
        c1.close();
        close();
        return sincdata;
    }


    /*Binclist*/
    public ArrayList<Bincmast> getallbinclist() {
        ArrayList<Bincmast> bincdata = new ArrayList<Bincmast>();
        openDataBase();
        Cursor c1 = myDataBase.rawQuery("SELECT * FROM  " + "DATA_BINCMAST", null);
        Log.e("DATA_BINCMAST", String.valueOf(c1.getColumnCount()));
        if (null != c1) {
            if (c1.moveToFirst()) {
                do {
                    Bincmast bincmast = new Bincmast();
                    bincmast.setSortname(c1.getString(c1.getColumnIndex("SORTNAME")));
                    bincmast.setBincode(c1.getString(c1.getColumnIndex("BIN_CODE")));
                    bincmast.setBinname(c1.getString(c1.getColumnIndex("BIN_NAME")));
                    bincmast.setBincaption(c1.getString(c1.getColumnIndex("BIN_CAPTION")));
                    bincdata.add(bincmast);
                } while (c1.moveToNext());
            }
        }
        c1.close();
        close();
        return bincdata;
    }

    /*Sbinclist*/
    public ArrayList<Sbincmast> getallsbinclist() {
        ArrayList<Sbincmast> sbincdata = new ArrayList<Sbincmast>();
        openDataBase();
        Cursor c1 = myDataBase.rawQuery("SELECT * FROM  " + "DATA_SBINCMAST", null);
        Log.e("DATA_SBINCMAST", String.valueOf(c1.getColumnCount()));
        if (null != c1) {
            if (c1.moveToFirst()) {
                do {
                    Sbincmast sbincmast = new Sbincmast();
                    sbincmast.setSortname(c1.getString(c1.getColumnIndex("SORTNAME")));
                    sbincmast.setSbinccode(c1.getString(c1.getColumnIndex("SBIN_CODE")));
                    sbincmast.setSbincname(c1.getString(c1.getColumnIndex("SBIN_NAME")));
                    sbincmast.setSbinccaption(c1.getString(c1.getColumnIndex("SBIN_CAPTION")));
                    sbincdata.add(sbincmast);
                } while (c1.moveToNext());
            }
        }
        c1.close();
        close();
        return sbincdata;
    }

    /*Brnlist*/
    public ArrayList<Brnmast> getallbrnlist() {
        ArrayList<Brnmast> brndata = new ArrayList<Brnmast>();
        openDataBase();
        Cursor c1 = myDataBase.rawQuery("SELECT * FROM  " + "DATA_BRNMAST", null);
        Log.e("DATA_BRNMAST", String.valueOf(c1.getColumnCount()));
        if (null != c1) {
            if (c1.moveToFirst()) {
                do {
                    Brnmast brnmast = new Brnmast();
                    brnmast.setSortname(c1.getString(c1.getColumnIndex("SORTNAME")));
                    brnmast.setBrncode(c1.getString(c1.getColumnIndex("BRN_CODE")));
                    brnmast.setBrnname(c1.getString(c1.getColumnIndex("BRN_NAME")));
                    brnmast.setBrncaption(c1.getString(c1.getColumnIndex("BRN_CAPTION")));
                    brndata.add(brnmast);
                } while (c1.moveToNext());
            }
        }
        c1.close();
        close();
        return brndata;
    }

    /*tensionlist*/
    public ArrayList<Tensionmast> getalltensionlist() {
        ArrayList<Tensionmast> tensiondata = new ArrayList<Tensionmast>();
        openDataBase();
        Cursor c1 = myDataBase.rawQuery("SELECT * FROM  " + "DATA_TENSIONMAST", null);
        Log.e("DATA_TENSIONMAST", String.valueOf(c1.getColumnCount()));
        if (null != c1) {
            if (c1.moveToFirst()) {
                do {
                    Tensionmast tensionmast = new Tensionmast();
                    tensionmast.setTncode(c1.getString(c1.getColumnIndex("TN_CODE")));
                    tensionmast.setTnname(c1.getString(c1.getColumnIndex("TN_NAME")));
                    tensiondata.add(tensionmast);
                } while (c1.moveToNext());
            }
        }
        c1.close();
        close();
        return tensiondata;
    }

    /*Versionlist*/
    public String getversioncode() {

        String vcode = null;
        openDataBase();
        Cursor c1 = myDataBase.query(true, "DATA_VERSIONMAST", new String[]{"V_CODE"}, null, null, "V_CODE", null, null, null);
        //vcode = "SELECT DISTINCT(V_CODE) FROM DATA_VERSIONMAST";
        if (null != c1) {
            if (c1.moveToFirst()) {
                do {

                    vcode = c1.getString(0);

                } while (c1.moveToNext());

            }
        }
        Log.e("VCode", vcode);
        c1.close();
        close();
        return vcode;
    }

    /*Calculate Union Query For  DATA_SIZEMAST,DATA_SRKSIZEMAST,IPAD_CPSMAST */


    public ArrayList calculate(double douPolPercent, String symcode, String cutcode) {
        ArrayList<SizeSrksizeIpadcpsmast> sizesrkipadcpslist = new ArrayList<>();

        String SQLiteStatement = (("SELECT IFNULL(SZ_CODE,0) AS Val,'SZ_CODE' Key, COUNT(*) AS Tot from DATA_SIZEMAST WHERE  " + douPolPercent + "  BETWEEN F_SIZE AND T_SIZE")
                + " " + "UNION ALL" + " " +
                ("SELECT IFNULL(SSZ_CODE,0) AS Val,'SSZ_CODE' Key, COUNT(*) AS Tot from DATA_SRKSIZEMAST WHERE  " + douPolPercent + "  BETWEEN F_SIZE AND T_SIZE")
                + " " + "UNION ALL" + " " +
                ("SELECT IFNULL(PL_CODE,0) AS Val,'PL_CODE' Key, COUNT(*) AS Tot from IPAD_CPSMAST WHERE  CT_CODE " + " =  " + cutcode + " AND " + "SY_CODE " + " = " + symcode));


        openDataBase();
        Cursor c1 = myDataBase.rawQuery(SQLiteStatement, null);

        if (null != c1) {
            if (c1.moveToFirst()) {
                do {

                    SizeSrksizeIpadcpsmast sizeSrksizeIpadcpsmast = new SizeSrksizeIpadcpsmast();
                    sizeSrksizeIpadcpsmast.setKey(c1.getString(c1.getColumnIndex("Key")));
                    sizeSrksizeIpadcpsmast.setVal(c1.getString(c1.getColumnIndex("Val")));
                    sizeSrksizeIpadcpsmast.setTot(c1.getString(c1.getColumnIndex("Tot")));
                    sizesrkipadcpslist.add(sizeSrksizeIpadcpsmast);

                } while (c1.moveToNext());

            }
        }

        c1.close();
        close();

        return sizesrkipadcpslist;
    }

    public ArrayList calculateRatMix(String scode, String colorcode, String SZ_CODE, String claritycode, String cutcode, String symcode, String flocode, String intPl_Code, String SSZ_CODE,
                                     String tinccode, String sinccode, String binccode, String sbinccode, String brncode, String tensioncode, double douRoughCarat) {
        ArrayList<RateMixmast> sizesrkipadcpslist = new ArrayList<>();
//        ArrayList<RateMixmast> ratemixdisclist = new ArrayList<>();
//        ArrayList<RateMixmast> CaratDiscountlist = new ArrayList<>();
//        ArrayList<RateMixmast> CutDiscountlist = new ArrayList<>();
//        ArrayList<RateMixmast> WTablwincllist = new ArrayList<>();
//        ArrayList<RateMixmast> WSidIn_Codelist = new ArrayList<>();
//        ArrayList<RateMixmast> BTabIn_Codelist = new ArrayList<>();
//        ArrayList<RateMixmast> BSidIn_Codelist = new ArrayList<>();
//        ArrayList<RateMixmast> Bro_Codelist = new ArrayList<>();
//        ArrayList<RateMixmast> Bro_Code_list = new ArrayList<>();
//        ArrayList<RateMixmast> RapAmtlist = new ArrayList<>();
        ArrayList<RateMixmast> RejectStonelist = new ArrayList<>();
        ArrayList<RateMixmast> RejectStone_list = new ArrayList<>();

        String strSelQaul, strSelCol;
        int Color_Code_Temp;

        int Clarity_Code_Temp;

        if (Integer.parseInt(claritycode) > 11)
            Clarity_Code_Temp = 11;
        else
            Clarity_Code_Temp = Integer.parseInt(claritycode);

        /*RATE  AND SINGLE MIX*/
        String Qcol = "Q" + ((Clarity_Code_Temp));

        String SQLiteStatement = (("SELECT IFNULL(" + Qcol + ",0) AS Val,'ORG' Key, COUNT(*) AS Tot from PARA_RAPORG WHERE  S_CODE " + "=" + scode + " AND "
                + "C_CODE " + "=" + colorcode + " AND "
                + "SZ_CODE " + "=" + SZ_CODE)

                + " " + "UNION ALL" + " " +

                ("SELECT IFNULL(" + Qcol + ",0) AS Val,'SINMIXDIS' Key, COUNT(*) AS Tot from PARA_SINMIX WHERE S_CODE " + "=" + scode + " AND "
                        + "C_CODE " + "=" + colorcode + " AND "
                        + "CT_CODE " + " =  " + cutcode + " AND "
                        + "SY_CODE " + " = " + symcode + " AND "
                        + "FL_CODE " + " = " + flocode + " AND "
                        + "PL_CODE " + " = " + intPl_Code + " AND "
                        + "SZ_CODE " + "=" + SZ_CODE));


        openDataBase();
        Cursor c1 = myDataBase.rawQuery(SQLiteStatement, null);

        if (null != c1) {
            if (c1.moveToFirst()) {
                do {

                    RateMixmast rateMixmast = new RateMixmast();
                    rateMixmast.setKey(c1.getString(c1.getColumnIndex("Key")));
                    rateMixmast.setVal(c1.getString(c1.getColumnIndex("Val")));
                    rateMixmast.setTot(c1.getString(c1.getColumnIndex("Tot")));
                    sizesrkipadcpslist.add(rateMixmast);

                } while (c1.moveToNext());

            }
        }

        c1.close();


        /*Rap Discount*/
        if ((sizesrkipadcpslist.get(1).getVal().equals("1") || (sizesrkipadcpslist.get(1).getVal().equals("0") && colorcode.equals("24")))) {
            strSelQaul = "M";
            strSelCol = "M";
        } else {
            strSelQaul = "Q";
            strSelCol = "C";
        }

        String Mcol = strSelQaul + Clarity_Code_Temp;

        SQLiteStatement +=
                " " + "UNION ALL" + " " +

                        ("SELECT IFNULL(" + Mcol + ",0) AS Val,'RAPDIS' Key, COUNT(*) AS Tot from PARA_RAPAPORT WHERE S_CODE " + "=" + scode + " AND "
                                + "C_CODE " + "=" + colorcode + " AND "
                                + "CT_CODE " + " =  " + cutcode + " AND "
                                + "SZ_CODE " + "=" + SZ_CODE);


//        Cursor c2 = myDataBase.rawQuery(SQLiteStatement, null);
//
//        if (null != c2) {
//            if (c2.moveToFirst()) {
//                do {
//
//                    RateMixmast rateMixmast = new RateMixmast();
//                    rateMixmast.setKey(c2.getString(c2.getColumnIndex("Key")));
//                    rateMixmast.setVal(c2.getString(c2.getColumnIndex("Val")));
//                    rateMixmast.setTot(c2.getString(c2.getColumnIndex("Tot")));
//                    ratemixdisclist.add(rateMixmast);
//
//                } while (c2.moveToNext());
//
//            }
//        }
//
//        c2.close();

        /*Carat Discount*/
        if (Integer.parseInt(colorcode) > 11)
            Color_Code_Temp = 11;
        else
            Color_Code_Temp = Integer.parseInt(colorcode);


        String Ccol = strSelCol + (Color_Code_Temp);
        String strPARA_CARAT_ = "PARA_CARAT_" + scode;


        SQLiteStatement +=
                " " + "UNION ALL" + " " +

                        ("SELECT IFNULL(" + Ccol + ",0) AS Val,'CARATDIS' Key, COUNT(*) AS Tot from " + strPARA_CARAT_ + " WHERE S_CODE " + "=" + scode + " AND "
                                + "CT_CODE " + " =  " + cutcode + " AND "
                                + "FL_CODE " + " = " + flocode + " AND "
                                + "QPARA " + "=" + Clarity_Code_Temp + " AND "
                                + "SSZ_CODE " + "=" + SSZ_CODE);


//        Cursor c3 = myDataBase.rawQuery(SQLiteStatement, null);
//
//        if (null != c3) {
//            if (c3.moveToFirst()) {
//                do {
//
//                    RateMixmast rateMixmast = new RateMixmast();
//                    rateMixmast.setKey(c3.getString(c3.getColumnIndex("Key")));
//                    rateMixmast.setVal(c3.getString(c3.getColumnIndex("Val")));
//                    rateMixmast.setTot(c3.getString(c3.getColumnIndex("Tot")));
//                    CaratDiscountlist.add(rateMixmast);
//
//                } while (c3.moveToNext());
//
//            }
//        }
//
//        c3.close();

       /* //Cut Discount*/

        String CcolDisc = strSelCol + (Color_Code_Temp);
        String strPARA_CPS_ = "PARA_CPS_" + scode;


        SQLiteStatement +=
                " " + "UNION ALL" + " " +

                        ("SELECT IFNULL(" + CcolDisc + ",0) AS Val,'CPSDIS' Key, COUNT(*) AS Tot from " + strPARA_CPS_ + " WHERE  CT_CODE " + " =  " + cutcode + " AND " +
                                "FL_CODE " + " = " + flocode + " AND "
                                + "S_CODE " + "=" + scode + " AND "
                                + "QPARA " + "=" + Clarity_Code_Temp + " AND "
                                + "IS_CODE " + "=" + SZ_CODE + " AND "
                                + "SY_CODE " + "=" + symcode);


//        Cursor c4 = myDataBase.rawQuery(SQLiteStatement, null);
//
//        if (null != c4) {
//            if (c4.moveToFirst()) {
//                do {
//
//                    RateMixmast rateMixmast = new RateMixmast();
//                    rateMixmast.setKey(c4.getString(c4.getColumnIndex("Key")));
//                    rateMixmast.setVal(c4.getString(c4.getColumnIndex("Val")));
//                    rateMixmast.setTot(c4.getString(c4.getColumnIndex("Tot")));
//                    CutDiscountlist.add(rateMixmast);
//
//                } while (c4.moveToNext());
//
//            }
//        }
//
//        c4.close();

        /*//Table white Inclusion Discount*/

        String Tablwincl = strSelCol + (Color_Code_Temp);

        SQLiteStatement +=
                " " + "UNION ALL" + " " +

                        ("SELECT IFNULL(" + Tablwincl + ",0) AS Val,'TINCDIS' Key, COUNT(*) AS Tot from " + "PARA_TINC" + " WHERE  IN_CODE " + " =  " + tinccode + " AND "
                                + "S_CODE " + "=" + scode + " AND "
                                + "FL_CODE " + " = " + flocode + " AND "
                                + "QPARA " + "=" + Clarity_Code_Temp + " AND "
                                + "IS_CODE " + "=" + SZ_CODE);


//        Cursor c5 = myDataBase.rawQuery(SQLiteStatement, null);
//
//        if (null != c5) {
//            if (c5.moveToFirst()) {
//                do {
//
//                    RateMixmast rateMixmast = new RateMixmast();
//                    rateMixmast.setKey(c5.getString(c5.getColumnIndex("Key")));
//                    rateMixmast.setVal(c5.getString(c5.getColumnIndex("Val")));
//                    rateMixmast.setTot(c5.getString(c5.getColumnIndex("Tot")));
//                    WTablwincllist.add(rateMixmast);
//
//                } while (c5.moveToNext());
//
//            }
//        }
//
//        c5.close();

        /*//Side white Inclusion Discount*/

        String SWINCDIS = strSelCol + (Color_Code_Temp);

        SQLiteStatement +=
                " " + "UNION ALL" + " " +

                        ("SELECT IFNULL(" + SWINCDIS + ",0) AS Val,'SWINCDIS' Key, COUNT(*) AS Tot from " + "PARA_SINC" + " WHERE  IN_CODE " + " =  " + sinccode + " AND "
                                + "S_CODE " + "=" + scode + " AND "
                                + "FL_CODE " + " = " + flocode + " AND "
                                + "QPARA " + "=" + Clarity_Code_Temp + " AND "
                                + "IS_CODE " + "=" + SZ_CODE);


//        Cursor c6 = myDataBase.rawQuery(SQLiteStatement, null);
//
//        if (null != c6) {
//            if (c6.moveToFirst()) {
//                do {
//
//                    RateMixmast rateMixmast = new RateMixmast();
//                    rateMixmast.setKey(c6.getString(c6.getColumnIndex("Key")));
//                    rateMixmast.setVal(c6.getString(c6.getColumnIndex("Val")));
//                    rateMixmast.setTot(c6.getString(c6.getColumnIndex("Tot")));
//                    WSidIn_Codelist.add(rateMixmast);
//
//                } while (c6.moveToNext());
//
//            }
//        }
//
//        c6.close();

       /* //Table Black Inclusion Discount*/
        String BINCDIS = strSelCol + (Color_Code_Temp);

        SQLiteStatement +=
                " " + "UNION ALL" + " " +

                        ("SELECT IFNULL(" + BINCDIS + ",0) AS Val,'BINCDIS' Key, COUNT(*) AS Tot from " + "PARA_BINC" + " WHERE  IN_CODE " + " =  " + binccode + " AND "
                                + "S_CODE " + "=" + scode + " AND "
                                + "FL_CODE " + " = " + flocode + " AND "
                                + "QPARA " + "=" + Clarity_Code_Temp + " AND "
                                + "IS_CODE " + "=" + SZ_CODE);


//        Cursor c7 = myDataBase.rawQuery(SQLiteStatement, null);
//
//        if (null != c7) {
//            if (c7.moveToFirst()) {
//                do {
//
//                    RateMixmast rateMixmast = new RateMixmast();
//                    rateMixmast.setKey(c7.getString(c7.getColumnIndex("Key")));
//                    rateMixmast.setVal(c7.getString(c7.getColumnIndex("Val")));
//                    rateMixmast.setTot(c7.getString(c7.getColumnIndex("Tot")));
//                    BTabIn_Codelist.add(rateMixmast);
//
//                } while (c7.moveToNext());
//
//            }
//        }
//
//        c7.close();

        /*//Side Black Inclusion Discount*/
        String SBINCDIS = strSelCol + (Color_Code_Temp);

        SQLiteStatement +=
                " " + "UNION ALL" + " " +

                        ("SELECT IFNULL(" + SBINCDIS + ",0) AS Val,'SBINCDIS' Key, COUNT(*) AS Tot from " + "PARA_SBINC" + " WHERE  IN_CODE " + " =  " + sbinccode + " AND "
                                + "S_CODE " + "=" + scode + " AND "
                                + "FL_CODE " + " = " + flocode + " AND "
                                + "QPARA " + "=" + Clarity_Code_Temp + " AND "
                                + "IS_CODE " + "=" + SZ_CODE);


//        Cursor c8 = myDataBase.rawQuery(SQLiteStatement, null);
//
//        if (null != c8) {
//            if (c8.moveToFirst()) {
//                do {
//
//                    RateMixmast rateMixmast = new RateMixmast();
//                    rateMixmast.setKey(c8.getString(c8.getColumnIndex("Key")));
//                    rateMixmast.setVal(c8.getString(c8.getColumnIndex("Val")));
//                    rateMixmast.setTot(c8.getString(c8.getColumnIndex("Tot")));
//                    BSidIn_Codelist.add(rateMixmast);
//
//                } while (c8.moveToNext());
//
//            }
//        }
//
//        c8.close();

       /* //Brown Discount*/

        String BRINCDIS = strSelCol + (Color_Code_Temp);

        SQLiteStatement +=
                " " + "UNION ALL" + " " +

                        ("SELECT IFNULL(" + BRINCDIS + ",0) AS Val,'BRINCDIS' Key, COUNT(*) AS Tot from " + "PARA_BRINC" + " WHERE  IN_CODE " + " =  " + brncode + " AND "
                                + "S_CODE " + "=" + scode + " AND "
                                + "FL_CODE " + " = " + flocode + " AND "
                                + "QPARA " + "=" + Clarity_Code_Temp + " AND "
                                + "IS_CODE " + "=" + SZ_CODE);


//        Cursor c9 = myDataBase.rawQuery(SQLiteStatement, null);
//
//        if (null != c9) {
//            if (c9.moveToFirst()) {
//                do {
//
//                    RateMixmast rateMixmast = new RateMixmast();
//                    rateMixmast.setKey(c9.getString(c9.getColumnIndex("Key")));
//                    rateMixmast.setVal(c9.getString(c9.getColumnIndex("Val")));
//                    rateMixmast.setTot(c9.getString(c9.getColumnIndex("Tot")));
//                    Bro_Codelist.add(rateMixmast);
//
//                } while (c9.moveToNext());
//
//            }
//        }
//        c9.close();


        SQLiteStatement +=
                " " + "UNION ALL" + " " +

                        ("SELECT IFNULL( (MNum*1.00/DNum*1.00) ,0) AS Val,'DOLDISC' Key, COUNT(*) AS Tot from " + "DATA_DOLDIFSIZE" + " WHERE  " + douRoughCarat + "  BETWEEN F_CARAT AND T_CARAT");


//        Cursor c10 = myDataBase.rawQuery(SQLiteStatement, null);
//
//        if (null != c10) {
//            if (c10.moveToFirst()) {
//                do {
//
//                    RateMixmast rateMixmast = new RateMixmast();
//                    rateMixmast.setKey(c10.getString(c10.getColumnIndex("Key")));
//                    rateMixmast.setVal(c10.getString(c10.getColumnIndex("Val")));
//                    rateMixmast.setTot(c10.getString(c10.getColumnIndex("Tot")));
//                    Bro_Code_list.add(rateMixmast);
//
//                } while (c10.moveToNext());
//
//            }
//        }
//        c10.close();

       /* //Rap Amount*/

        String RAPDIS = strSelQaul + (Clarity_Code_Temp);

        SQLiteStatement +=
                " " + "UNION ALL" + " " +

                        ("SELECT IFNULL(" + RAPDIS + ",0) AS Val,'RAPDIS' Key, COUNT(*) AS Tot from " + "PARA_RAPAPORT_RATE" + " WHERE  S_CODE " + "=" + scode + " AND "
                                + "C_CODE " + " = " + colorcode + " AND "
                                + "CT_CODE " + "=" + cutcode + " AND "
                                + "SZ_CODE " + "=" + SZ_CODE);

//        Cursor c11 = myDataBase.rawQuery(SQLiteStatement, null);
//
//        if (null != c11) {
//            if (c11.moveToFirst()) {
//                do {
//
//                    RateMixmast rateMixmast = new RateMixmast();
//                    rateMixmast.setKey(c11.getString(c11.getColumnIndex("Key")));
//                    rateMixmast.setVal(c11.getString(c11.getColumnIndex("Val")));
//                    rateMixmast.setTot(c11.getString(c11.getColumnIndex("Tot")));
//                    RapAmtlist.add(rateMixmast);
//
//                } while (c11.moveToNext());
//
//            }
//        }
//        c11.close();

       /* //Check Reject Stone*/

        SQLiteStatement +=
                " " + "UNION ALL" + " " +

                        ("SELECT IFNULL(SRNO,0) AS Val,'REJECTSTONE' Key, COUNT(*) AS Tot from " + "PARA_RAPREJECT" + " WHERE  S_CODE " + "=" + scode + " AND "
                                + "IS_CODE " + " = " + SZ_CODE + " AND "
                                + (Clarity_Code_Temp + " BETWEEN FQ_CODE AND FQ_CODE") + " AND "
                                + (colorcode + " BETWEEN FC_CODE AND TC_CODE") + " AND "
                                + (flocode + " BETWEEN FFL_CODE AND TFL_CODE") + " AND "
                                + (cutcode + " BETWEEN FCT_CODE AND TCT_CODE") + " AND "
                                + (brncode + " BETWEEN FBRN_CODE AND TBRN_CODE")
                        );

        Cursor c12 = myDataBase.rawQuery(SQLiteStatement, null);

        if (null != c12) {
            if (c12.moveToFirst()) {
                do {

                    RateMixmast rateMixmast = new RateMixmast();
                    rateMixmast.setKey(c12.getString(c12.getColumnIndex("Key")));
                    rateMixmast.setVal(c12.getString(c12.getColumnIndex("Val")));
                    rateMixmast.setTot(c12.getString(c12.getColumnIndex("Tot")));
                    RejectStonelist.add(rateMixmast);

                    RejectStone_list.add(rateMixmast);

                } while (c12.moveToNext());

            }
        }
        c12.close();

        if (Integer.parseInt(claritycode) > 11) {
            RejectStone_list.clear();
            SQLiteStatement +=
                    " " + "UNION ALL" + " " +

                            ("SELECT IFNULL(BASEPQ_DIFFPER,0) AS Val,'RAPDIS' Key, COUNT(*) AS Tot from " + "DATA_QUAMAST" + " WHERE  Q_CODE " + "=" + claritycode);


            Cursor c13 = myDataBase.rawQuery(SQLiteStatement, null);

            if (null != c13) {
                if (c13.moveToFirst()) {

                    do {

                        RateMixmast rateMixmast = new RateMixmast();
                        rateMixmast.setKey(c13.getString(c13.getColumnIndex("Key")));
                        rateMixmast.setVal(c13.getString(c13.getColumnIndex("Val")));
                        rateMixmast.setTot(c13.getString(c13.getColumnIndex("Tot")));
                        RejectStone_list.add(rateMixmast);

                    } while (c13.moveToNext());

                }
            }
            c13.close();
        }
        close();
        return RejectStone_list;
    }

}