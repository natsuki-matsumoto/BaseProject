package Temp;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * データ型のテンプレート一覧
 */
public interface I_DataTypeList {

    // KEY 一覧.
    String KEY_BOOLEAN = "boolean";
    String KEY_BYTE = "byte";
    String KEY_CHAR = "char";
    String KEY_SHORT = "short";
    String KEY_INT = "int";
    String KEY_FLOAT = "float";
    String KEY_LONG = "long";
    String KEY_DOUBLE = "double";
    String KEY_STRING = "String";
    String KEY_SERIALIZABLE = "Serializable";
    String KEY_PARCELABLE = "Parcelable";

    // プリミティブ型.
    boolean mBoolean = true;
    byte mByte = 0;
    char mChar = 0;
    short mShort = 0;
    int mInt = 0;
    float mFloat = 0f;
    long mLong = 0L;
    double mDouble = 0d;
    // 参照型.
    String mString = "String";
    // Serializable 継承クラス.
    SerializableClass mSerializableClass = new SerializableClass();
    // Parcelable 継承クラス.
    ParcelableClass mParcelableClass = new ParcelableClass();

    // 配列.
    boolean[] mBooleans = new boolean[]{true};
    byte[] mBytes = new byte[]{0};
    char[] mChars = new char[]{0};
    short[] mShorts = new short[]{0};
    int[] mInts = new int[]{0};
    float[] mFloats = new float[]{0f};
    long[] mLongs = new long[]{0L};
    double[] mDoubles = new double[]{0d};
    String[] mStrings = new String[]{"String"};
    SerializableClass[] mSerializableClasses = new SerializableClass[]{new SerializableClass()};
    ParcelableClass[] mParcelableClasses = new ParcelableClass[]{new ParcelableClass()};

    // List.
    List<Boolean> mBooleanList = new ArrayList<>(Arrays.asList(true));
    List<Byte> mByteList = new ArrayList<>(Arrays.asList((byte) 0));
    List<Character> mCharacterList = new ArrayList<>(Arrays.asList((char) 0));
    List<Short> mShortList = new ArrayList<>(Arrays.asList((short) 0));
    List<Integer> mIntegerList = new ArrayList<>(Arrays.asList(0));
    List<Float> mFloatList = new ArrayList<>(Arrays.asList(0f));
    List<Long> mLongList = new ArrayList<>(Arrays.asList(0L));
    List<Double> mDoubleList = new ArrayList<>(Arrays.asList(0d));
    List<String> mStringList = new ArrayList<>(Arrays.asList("String"));
    List<SerializableClass> mSerializableClasseList = new ArrayList<>(Arrays.asList(new SerializableClass()));
    List<ParcelableClass> mParcelableClassList = new ArrayList<>(Arrays.asList(new ParcelableClass()));

    // Map
    Map<String, Boolean> mBooleanMap = new HashMap<String, Boolean>() {{
        put(KEY_BOOLEAN, true);
    }};
    Map<String, Byte> mByteMap = new HashMap<String, Byte>() {{
        put(KEY_BYTE, (byte) 0);
    }};
    Map<String, Character> mCharacterMap = new HashMap<String, Character>() {{
        put(KEY_CHAR, (char) 0);
    }};
    Map<String, Short> mShortMap = new HashMap<String, Short>() {{
        put(KEY_SHORT, (short) 0);
    }};
    Map<String, Integer> mIntegerMap = new HashMap<String, Integer>() {{
        put(KEY_INT, 0);
    }};
    Map<String, Float> mFloatMap = new HashMap<String, Float>() {{
        put(KEY_FLOAT, 0f);
    }};
    Map<String, Long> mLongMap = new HashMap<String, Long>() {{
        put(KEY_LONG, 0L);
    }};
    Map<String, Double> mDoubleMap = new HashMap<String, Double>() {{
        put(KEY_DOUBLE, 0d);
    }};
    Map<String, String> mStringMap = new HashMap<String, String>() {{
        put(KEY_STRING, "String");
    }};
    Map<String, SerializableClass> mSerializableClassMap = new HashMap<String, SerializableClass>() {{
        put(KEY_SERIALIZABLE, new SerializableClass());
    }};
    Map<String, ParcelableClass> mParcelableClassMap = new HashMap<String, ParcelableClass>() {{
        put(KEY_PARCELABLE, new ParcelableClass());
    }};

    /**
     * Serializable クラス.
     */
    class SerializableClass implements Serializable {
        // シリアルバージョンID.
        // 定義することで、シリアライズからデシリアライズまでの間にクラスの中身が
        // 変更されていた場合、Exceptionを出してくれる.
        private static final long serialVersionUID = 6255752248513019027L;

        // transient修飾子 設定でシリアライズ対象外.
        transient JSONObject jsonObject = new JSONObject();

        // プリミティブ型
        boolean mBoolean = true;
        byte mByte = 0;
        char mChar = 0;
        short mShort = 0;
        int mInt = 0;
        float mFloat = 0f;
        long mLong = 0L;
        double mDouble = 0d;
        // 参照型
        String mString = "String";
        // Serializable 継承クラス.
//        SerializableClass mSerializableClass = new SerializableClass();
        // Parcelable 継承クラス.
//        ParcelableClass mParcelableClass = new ParcelableClass();

        // 配列
        boolean[] mBooleans = new boolean[]{true};
        byte[] mBytes = new byte[]{0};
        char[] mChars = new char[]{0};
        short[] mShorts = new short[]{0};
        int[] mInts = new int[]{0};
        float[] mFloats = new float[]{0f};
        long[] mLongs = new long[]{0L};
        double[] mDoubles = new double[]{0d};
        String[] mStrings = new String[]{"String"};
//        SerializableClass[] mSerializableClasses = new SerializableClass[]{new SerializableClass()};
//        ParcelableClass[] mParcelableClasses = new ParcelableClass[]{new ParcelableClass()};

        // List
        List<Boolean> mBooleanList = new ArrayList<>(Arrays.asList(true));
        List<Byte> mByteList = new ArrayList<>(Arrays.asList((byte) 0));
        List<Character> mCharacterList = new ArrayList<>(Arrays.asList((char) 0));
        List<Short> mShortList = new ArrayList<>(Arrays.asList((short) 0));
        List<Integer> mIntegerList = new ArrayList<>(Arrays.asList(0));
        List<Float> mFloatList = new ArrayList<>(Arrays.asList(0f));
        List<Long> mLongList = new ArrayList<>(Arrays.asList(0L));
        List<Double> mDoubleList = new ArrayList<>(Arrays.asList(0d));
        List<String> mStringList = new ArrayList<>(Arrays.asList("String"));
//        List<SerializableClass> mSerializableClasseList = new ArrayList<>(Arrays.asList(new SerializableClass()));
//        List<ParcelableClass> mParcelableClassList = new ArrayList<>(Arrays.asList(new ParcelableClass()));

        // Map
        Map<String, Boolean> mBooleanMap = new HashMap<String, Boolean>() {{
            put(KEY_BOOLEAN, true);
        }};
        Map<String, Byte> mByteMap = new HashMap<String, Byte>() {{
            put(KEY_BYTE, (byte) 0);
        }};
        Map<String, Character> mCharacterMap = new HashMap<String, Character>() {{
            put(KEY_CHAR, (char) 0);
        }};
        Map<String, Short> mShortMap = new HashMap<String, Short>() {{
            put(KEY_SHORT, (short) 0);
        }};
        Map<String, Integer> mIntegerMap = new HashMap<String, Integer>() {{
            put(KEY_INT, 0);
        }};
        Map<String, Float> mFloatMap = new HashMap<String, Float>() {{
            put(KEY_FLOAT, 0f);
        }};
        Map<String, Long> mLongMap = new HashMap<String, Long>() {{
            put(KEY_LONG, 0L);
        }};
        Map<String, Double> mDoubleMap = new HashMap<String, Double>() {{
            put(KEY_DOUBLE, 0d);
        }};
        Map<String, String> mStringMap = new HashMap<String, String>() {{
            put(KEY_STRING, "String");
        }};
        //        Map<String, SerializableClass> mSerializableClassMap = new HashMap<String, SerializableClass>() {{
//            put(KEY_SERIALIZABLE, new SerializableClass());
//        }};
//        Map<String, ParcelableClass> mParcelableClassMap = new HashMap<String, ParcelableClass>() {{
//            put(KEY_PARCELABLE, new ParcelableClass());
//        }};
    }

    /**
     * Parcelable クラス.
     */
    class ParcelableClass implements Parcelable {
        // プリミティブ型.
        boolean mBoolean = true;
        int mInt = 0;
        String mString = "String";
        SerializableClass mSerializableClass = new SerializableClass();
        InnerDataParacelableClass mInnerDataParacelableClass = new InnerDataParacelableClass();

        // 配列.
        float[] mFloats = new float[]{0f};
        String[] mStrings = new String[]{"String"};
        SerializableClass[] mSerializableClasses = new SerializableClass[]{new SerializableClass()};
        InnerDataParacelableClass[] mInnerDataParacelableClasses = new InnerDataParacelableClass[]{new InnerDataParacelableClass()};

        // List.
        List<Integer> mIntegerList = new ArrayList<>(Arrays.asList(0));
        List<String> mStringList = new ArrayList<>(Arrays.asList("String"));
        List<SerializableClass> mSerializableClasseList = new ArrayList<>(Arrays.asList(new SerializableClass()));
        List<InnerDataParacelableClass> mInnerDataParacelableClassList = new ArrayList<>(Arrays.asList(new InnerDataParacelableClass()));

        // Map
        Map<String, Long> mLongMap = new HashMap<String, Long>() {{
            put(KEY_LONG, 0L);
        }};
        Map<String, String> mStringMap = new HashMap<String, String>() {{
            put(KEY_STRING, "String");
        }};
        Map<String, SerializableClass> mSerializableClassMap = new HashMap<String, SerializableClass>() {{
            put(KEY_SERIALIZABLE, new SerializableClass());
        }};
        Map<String, InnerDataParacelableClass> mInnerDataParacelableClassMap = new HashMap<String, InnerDataParacelableClass>() {{
            put(KEY_PARCELABLE, new InnerDataParacelableClass());
        }};

        /**
         * コンストラクタ.
         * メンバ変数の初期化などを行う.
         */
        public ParcelableClass() {
        }

        /**
         * データ読み出し.
         * writeToParcel()と順番を合わせる.
         *
         * @param in
         */
        private ParcelableClass(Parcel in) {
            mBoolean = in.readByte() == 1;
            mInt = in.readInt();
            mString = in.readString();
            mSerializableClass = (SerializableClass) in.readSerializable();
            mInnerDataParacelableClass = in.readParcelable(InnerDataParacelableClass.class.getClassLoader());

            in.readFloatArray(mFloats);
            in.readStringArray(mStrings);
            Object[] objects = in.readArray(SerializableClass[].class.getClassLoader());
            mSerializableClasses = Arrays.copyOf(objects, objects.length, SerializableClass[].class);
            in.readParcelableArray(InnerDataParacelableClass.class.getClassLoader());

            in.readList(mIntegerList, int.class.getClassLoader());
            in.readStringList(mStringList);
            in.readList(mSerializableClasseList, SerializableClass.class.getClassLoader());
            in.readList(mInnerDataParacelableClassList, InnerDataParacelableClass.class.getClassLoader());

            mLongMap = in.readHashMap(long.class.getClassLoader());
            mStringMap = in.readHashMap(String.class.getClassLoader());
            mSerializableClassMap = in.readHashMap(SerializableClass.class.getClassLoader());
            mInnerDataParacelableClassMap = in.readHashMap(InnerDataParacelableClass.class.getClassLoader());
        }

        /**
         * データ書き込み.
         * コンストラクタ(Parcel in)と順番を合わせる.
         *
         * @param out
         * @param flags
         */
        public void writeToParcel(Parcel out, int flags) {
            out.writeByte((byte) (mBoolean ? 1 : 0));
            out.writeInt(mInt);
            out.writeString(mString);
            out.writeSerializable(mSerializableClass);
            out.writeParcelable(mInnerDataParacelableClass, flags);

            out.writeFloatArray(mFloats);
            out.writeStringArray(mStrings);
            out.writeArray(mSerializableClasses);
            out.writeParcelableArray(mInnerDataParacelableClasses, flags);

            out.writeList(mIntegerList);
            out.writeStringList(mStringList);
            out.writeList(mSerializableClasseList);
            out.writeList(mInnerDataParacelableClassList);

            out.writeMap(mLongMap);
            out.writeMap(mStringMap);
            out.writeMap(mSerializableClassMap);
            out.writeMap(mInnerDataParacelableClassMap);
        }

        /**
         * Parcelable.Creatorインタフェースを実装した静的フィールド.
         */
        public static final Creator<ParcelableClass> CREATOR
                = new Creator<ParcelableClass>() {
            public ParcelableClass createFromParcel(Parcel in) {
                return new ParcelableClass(in);
            }

            public ParcelableClass[] newArray(int size) {
                return new ParcelableClass[size];
            }
        };

        public int describeContents() {
            return 0;
        }

        /**
         * 内部データクラス.
         */
        private static class InnerDataParacelableClass implements Parcelable {
            private int mInt = 123;
            private String mString = "文字列";

            public InnerDataParacelableClass() {
            }

            private InnerDataParacelableClass(Parcel in) {
                mInt = in.readInt();
                mString = in.readString();
            }

            @Override
            public void writeToParcel(Parcel out, int flags) {
                out.writeInt(mInt);
                out.writeString(mString);
            }

            public static final Creator<InnerDataParacelableClass> CREATOR
                    = new Creator<InnerDataParacelableClass>() {
                public InnerDataParacelableClass createFromParcel(Parcel in) {
                    return new InnerDataParacelableClass(in);
                }

                public InnerDataParacelableClass[] newArray(int size) {
                    return new InnerDataParacelableClass[size];
                }
            };

            @Override
            public int describeContents() {
                return 0;
            }
        }
    }
}
