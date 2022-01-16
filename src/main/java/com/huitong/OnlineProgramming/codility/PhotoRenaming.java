package com.huitong.OnlineProgramming.codility;

import java.util.*;

/**
 * @author Qiushui.Zhe
 * @date 2022/01/15 21:51
 */

/**
 * 题目：Eric是一位摄影爱好者，每次拍照后都会将照片命名并用一条记录来标记该照片
 * 随着照片的增多，Eric发现现有的命名都乱掉了，他决定重新命名。
 * 现要求提供新命令的解决方案
 *
 * 旧的命名规则：
 * 1. 照片名字，拍摄地点，拍摄时间。 三者之间用逗号分割
 * 例如："john.png, Beijing, 2015-06-20 15:13:22
 * 2.照片名字的后缀名字为 ”jpg或者png“
 * 3.拍摄日期格式为 YYYY-MM-DD hh:mm:ss
 * 4.同一地点拍摄的照片，拍摄时间都是唯一的，没有重复
 *
 * 新的命名规则：
 * 1.照片名字为 ${拍摄地点}${该拍摄地点按拍摄时间先后顺序生成的编号}.${后缀名}
 * 比如
 *                 a.png, Beijing, 2016-02-13 13:33:50
 *                 b.jpg, Beijing, 2016-01-02 15:12:22
 * 同样在Beijing拍摄的两张照片，由于b.jpg拍摄时间早于a.png，所以最后命名的结果为
 * Beijing2.png
 * Beijing1.png
 * 2.对于${该拍摄地点按拍摄时间先后顺序生成的编号}，需要根据照片的数量进行补”0“
 * 比如，拍摄于Beijing的照片一共有100 张，那么照片编号格式应该为 001,002，003，...010..085....
 *
 * 现假设给定的现有照片的记录每一个拍摄地最多100张照片，请给出解决方案。
 * 参考例子如下：
 *          hoto.jpg, Warsaw, 2013-09-05 14:08:15
 *          john.png, London, 2015-06-20 15:13:22
 *          myFriends.png, Warsaw, 2013-09-05 14:07:13
 *          Eiffel.jpg, Paris, 2015-07-23 08:03:02
 *          pisatower.jpg, Paris, 2015-07-22 23:59:59
 *          BOB.jpg, London, 2015-08-05 00:02:03
 *          notredame.png, Paris, 2015-09-01 12:00:00
 *          me.jpg, Warsaw, 2013-09-06 15:40:22
 *          a.png, Warsaw, 2016-02-13 13:33:50
 *          b.jpg, Warsaw, 2016-01-02 15:12:22
 *          c.jpg, Warsaw, 2016-01-02 14:34:30
 *          d.jpg, Warsaw, 2016-01-02 15:15:01
 *          e.png, Warsaw, 2016-01-02 09:49:09
 *          f.png, Warsaw, 2016-01-02 10:55:32
 *          g.jpg, Warsaw, 2016-02-29 22:13:11
 *
 * 期望重命名的记录名字为
 *         Warsaw02.jpg
 *         London1.png
 *         Warsaw01.png
 *         Paris2.jpg
 *         Paris1.jpg
 *         London2.jpg
 *         Paris3.png
 *         Warsaw03.jpg
 *         Warsaw09.png
 *         Warsaw07.jpg
 *         Warsaw06.jpg
 *         Warsaw08.jpg
 *         Warsaw04.png
 *         Warsaw05.png
 *         Warsaw10.jpg
 */
public class PhotoRenaming {
    public String solution(String S) {
        List<Photo> photos = new ArrayList<>();
        HashMap<String, List<Photo>> map = new HashMap<>();
        String[] lines = S.split("\n");

        for (String line : lines) {
            String[] items = line.split(",");
            Photo photo = new Photo();
            photo.setExt(items[0].substring(items[0].indexOf(".")));
            photo.setLocation(items[1].trim());
            String tmp = items[2].replaceAll("-", "")
                    .replaceAll(" ", "")
                    .replaceAll(":", "");
            photo.setTime(Long.valueOf(tmp));
            photos.add(photo);
            if (map.containsKey(photo.getLocation())) {
                map.get(photo.getLocation()).add(photo);
            } else {
                ArrayList<Photo> pl = new ArrayList<>();
                pl.add(photo);
                map.put(photo.getLocation(), pl);
            }
        }

        map.forEach((k, v) -> {
            v.sort(new Comparator<Photo>() {
                @Override
                public int compare(Photo o1, Photo o2) {
                    if (o1.getTime() < o2.getTime()) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            });
            int size = v.size();
            for (int i = 0; i < v.size(); i++) {

                int value = i + 1;
                if (size < 10) {
                    v.get(i).setStrNum("" + value);
                } else if (size == 10) {
                    if (value < 10) {
                        v.get(i).setStrNum("0" + value);
                    } else {
                        v.get(i).setStrNum("" + value);
                    }
                } else if (size <= 100) {
                    if (value < 10) {
                        v.get(i).setStrNum("00" + value);
                    } else if (value == 10) {
                        v.get(i).setStrNum("0" + value);
                    } else if (value < 100) {
                        v.get(i).setStrNum("0" + value);
                    } else {
                        v.get(i).setStrNum("" + value);
                    }
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        photos.forEach(photo -> {
            if (sb.length() > 0) {
                sb.append("\n");
            }
            sb.append(photo.getLocation()).append(photo.getStrNum()).append(photo.getExt());
        });
        return sb.toString();

    }

    class Photo {
        String location;
        String strNum;
        long time;
        String ext;

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getStrNum() {
            return strNum;
        }

        public void setStrNum(String strNum) {
            this.strNum = strNum;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public String getExt() {
            return ext;
        }

        public void setExt(String ext) {
            this.ext = ext;
        }
    }

    public static void main(String[] args) {
        PhotoRenaming test2 = new PhotoRenaming();
        String s = "hoto.jpg, Warsaw, 2013-09-05 14:08:15\n" +
                "john.png, London, 2015-06-20 15:13:22\n" +
                "myFriends.png, Warsaw, 2013-09-05 14:07:13\n" +
                "Eiffel.jpg, Paris, 2015-07-23 08:03:02\n" +
                "pisatower.jpg, Paris, 2015-07-22 23:59:59\n" +
                "BOB.jpg, London, 2015-08-05 00:02:03\n" +
                "notredame.png, Paris, 2015-09-01 12:00:00\n" +
                "me.jpg, Warsaw, 2013-09-06 15:40:22\n" +
                "a.png, Warsaw, 2016-02-13 13:33:50\n" +
                "b.jpg, Warsaw, 2016-01-02 15:12:22\n" +
                "c.jpg, Warsaw, 2016-01-02 14:34:30\n" +
                "d.jpg, Warsaw, 2016-01-02 15:15:01\n" +
                "e.png, Warsaw, 2016-01-02 09:49:09\n" +
                "f.png, Warsaw, 2016-01-02 10:55:32\n" +
                "g.jpg, Warsaw, 2016-02-29 22:13:11";
        String result = test2.solution(s);
        System.out.println(result);
//Expected result is
//        Warsaw02.jpg
//        London1.png
//        Warsaw01.png
//        Paris2.jpg
//        Paris1.jpg
//        London2.jpg
//        Paris3.png
//        Warsaw03.jpg
//        Warsaw09.png
//        Warsaw07.jpg
//        Warsaw06.jpg
//        Warsaw08.jpg
//        Warsaw04.png
//        Warsaw05.png
//        Warsaw10.jpg
    }
}
