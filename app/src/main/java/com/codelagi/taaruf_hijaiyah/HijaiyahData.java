package com.codelagi.taaruf_hijaiyah;
import java.util.ArrayList;

public class HijaiyahData {

    private static String[] hijaiyahNames = {
            "Alif",
            "Ba",
            "Ta",
            "Tsa",
            "Jim",
            "Ha",
            "Kho",
            "Dal",
            "Dzal",
            "Ro",
            "Zay",
            "Sin",
            "Syin",
            "Shod",
            "Dhod",
            "Tho",
            "Dzho",
            "Ain",
            "Ghoin",
            "Fa",
            "Qof",
            "Kaf",
            "Lam",
            "Mim",
            "Nun",
            "Wawu",
            "HHA",
            "Hamzah",
            "Yaa",
    };

    private static String[] hijaiyahDetails = {
            "Yang dimaksud kata muthlaq pada Alif muthlaq adalah bahwa alif itu selamanya pasti sukun dan pasti jatuh setelah harakot fathah, karena itu penulisan alif (dalam al-Qurán) meskipun tidak ada tandanya sukun, ia sudah mati/sukun dengan sendirinya. Bila ada huruf ditulis bentuknya seperti alif, tetapi berharokat seperti ﺍﻠﺤﻤﺪﷲ ini bukan alif tetapi hamzah namanya:\n" +
                    "Alif itu ada dua macam :\n" +
                    "Alif mamdudah (yang dipanjangkan) seperti : ﻤﺎ ﻻ ﻄﺎﻘﺔ ﻠﻨﺎﺒﻪ\n" +
                    "Alif layyinah (yang lunak) ada yang mengatakan alif bengkok, seperti : ﻮﺍﻠﻨﺠﻢ ﺍﺪﺍﻫﻮ - ﻯﻮﻤﺎﻏﻮﻯ",
            "keluar diantara dua bibir (antara bibir atas dan bawah), hanya saja untuk wawu bibir membuka, sedang untuk bak dan mim bibir membungkam.",
            "Ujung lidah bertemu dengan pangkal gigi seri atas",
            "Ujung lidah bertemu dengan ujung gigi seri atas",
            "Pertengahan lidah bertemu dengan langit-langit atas.",
            "tenggorokan bagian tengah",
            "tenggorokan bagian luar atau ujung tenggorokan",
            "Ujung lidah bertemu dengan pangkal gigi seri atas",
            "Ujung lidah bertemu dengan ujung gigi seri atas",
            "Berdekatan dengan makhraj nun dan masuk pada punggung lidah, tetapi lidah tidak menyentuh langit-langit.",
            "Ujung lidah bertemu dengan ujung gigi seri bawah",
            "Ujung lidah bertemu dengan ujung gigi seri bawah",
            "Pertengahan lidah tersebut dimantapkan (tidak menempel) pada langit-langit atas",
            "Ujung lidah bertemu dengan ujung gigi seri bawah",
            "Tepi lidah bersentuhan dengan geraham kanan atau kiri. Ada juga yang mengatakan tepi pangkal lidah dengan geraham kanan atau kiri memanjang sampai ke depan",
            "Ujung lidah bertemu dengan pangkal gigi seri atas",
            "Ujung lidah bertemu dengan ujung gigi seri atas",
            "tenggorokan bagian tengah",
            "tenggorokan bagian luar atau ujung tenggorokan",
            "keluar dari dalamnya bibir yang bawah, serta menepati dengan ujung gigi dua yang atas.",
            "angkal lidah bertemu dengan langit-langit bagian atas",
            "Pangkal lidah, tepatnya sebelah bawah (atau ke depan) sedikit dari makhraj qaf, bertemu dengan langit-langit bagian atas",
            "Ujung lidah bertemu dengan langit-langit yang berhadapan dengannya",
            "keluar diantara dua bibir (antara bibir atas dan bawah)" + "Dari makhraj ini keluar satu makhraj, yaitu al-ghunnah (sengau/dengung), sehingga dari makhraj inilah keluar segala bunyi sengau/dengung. Setidaknya ada empat tempat yang padanya terjadi bunyi sengau, yaitu pada bacaan ghunnah musyaddad, yakni bacaan sengau pada huruf mim dan nun yang bertasydid: مّ – نّ; pada bacaan Idham bi Ghunnah; pada bacaan Ikhfa; dan pada bacaan Iqlab.\n",
            "Dari makhraj ini keluar satu makhraj, yaitu al-ghunnah (sengau/dengung), sehingga dari makhraj inilah keluar segala bunyi sengau/dengung. Setidaknya ada empat tempat yang padanya terjadi bunyi sengau, yaitu pada bacaan ghunnah musyaddad, yakni bacaan sengau pada huruf mim dan nun yang bertasydid: مّ – نّ; pada bacaan Idham bi Ghunnah; pada bacaan Ikhfa; dan pada bacaan Iqlab.\n",
            " keluar diantara dua bibir (atas dan bawah) serta lazimnya disebut huruf syafawiyah artinya huruf-huruf sebangsa bibir.",
            "pangkal tenggorokan atau tenggorokan bagian dalam",
            "pangkal tenggorokan atau tenggorokan bagian dalam",
            " keluar dari tengah-tengah lidah tepat, serta menepati dengan langit-langit mulut atas dan lazimnya disebut huruf syajariyah artinya huruf-huruf sebangsa tengah lidah (coba ucapkan kedua huruf tersebut dalam keadaan mati dan hidup kemudian perhatikan dan rasakan makhrajnya.",
    };

    private static int[] hijaiyahImages ={
        R.drawable.alif, R.drawable.ba, R.drawable.ta, R.drawable.tsa, R.drawable.ja, R.drawable.ha, R.drawable.kha, R.drawable.da,
        R.drawable.dzal, R.drawable.ra, R.drawable.zay, R.drawable.sa, R.drawable.syin, R.drawable.shod, R.drawable.dhod, R.drawable.tho,
        R.drawable.dzho, R.drawable.ain, R.drawable.ghoin, R.drawable.fa, R.drawable.qof, R.drawable.kaf, R.drawable.lam, R.drawable.mim,
        R.drawable.nun, R.drawable.wau, R.drawable.hha, R.drawable.alif, R.drawable.ya,


    };

    static ArrayList<Hijaiyah> getListData(){
        ArrayList<Hijaiyah> list = new ArrayList<Hijaiyah>();
        for(int position =0; position < hijaiyahNames.length; position++){
            Hijaiyah hijaiyah = new Hijaiyah();
            hijaiyah.setName(hijaiyahNames[position]);
            hijaiyah.setDetail(hijaiyahDetails[position]);
            hijaiyah.setPhoto(hijaiyahImages[position]);
            list.add(hijaiyah);
        }
        return list;
    }
}
