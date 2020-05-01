package com.gogxi.moviecatalogue.utils;

import com.gogxi.moviecatalogue.data.remote.entity.Movie;
import com.gogxi.moviecatalogue.data.remote.entity.TV;

import java.util.ArrayList;
import java.util.List;

public class DataDummy {

    public static List<Movie> generateDummyMovie() {
        ArrayList<Movie> movies = new ArrayList<>();

        movies.add(new Movie(
                419704,
                "Ad Astra",
                "The near future, a time when both hope and hardships drive humanity to look to the stars and beyond. While a mysterious phenomenon menaces to destroy life on planet Earth, astronaut Roy McBride undertakes a mission across the immensity of space and its many perils to uncover the truth about a lost expedition that decades before boldly faced emptiness and silence in search of the unknown.",
                "2019-09-17",
                "en",
                "/xBHvZcjRiWyobQ9kxBhO6B2dtRI.jpg",
                "/5BwqwxMEjeFtdknRV792Svo0K1v.jpg",
                6.0,
                null
        ));
        movies.add(new Movie(
                454626,
                "Sonic the Hedgehog",
                "Based on the global blockbuster videogame franchise from Sega, Sonic the Hedgehog tells the story of the world’s speediest hedgehog as he embraces his new home on Earth. In this live-action adventure comedy, Sonic and his new best friend team up to defend the planet from the evil genius Dr. Robotnik and his plans for world domination.",
                "2020-02-12",
                "en",
                "/aQvJ5WPzZgYVDrxLX4R6cLJCEaQ.jpg",
                "/stmYfCUGd8Iy6kAMBr6AmWqx8Bq.jpg",
                7.6,
                null
        ));
        movies.add(new Movie(
                443791,
                "Underwater",
                "After an earthquake destroys their underwater station, six researchers must navigate two miles along the dangerous, unknown depths of the ocean floor to make it to safety in a race against time.",
                "2020-01-08",
                "en",
                "/gzlbb3yeVISpQ3REd3Ga1scWGTU.jpg",
                "/ww7eC3BqSbFsyE5H5qMde8WkxJ2.jpg",
                6.4,
                null
        ));
        movies.add(new Movie(
                664413,
                "36 Days",
                "Laura, in order to save her relationship from falling apart, goes to Sicily, where she meets Massimo. A dangerous man, the head of a mafia family, kidnaps her and gives her 365 days to fall in love with him.",
                "2020-02-07",
                "pl",
                "/plWcrWkuIPbNgQlIFwDr6jt2Mld.jpg",
                "/gePCMmgv7r2DUO4pHZY2JE6fkKJ.jpg",
                5.4,
                null
        ));
        movies.add(new Movie(
                38700,
                "Bad Boys For Life",
                "Marcus and Mike are forced to confront new threats, career changes, and midlife crises as they join the newly created elite team AMMO of the Miami police department to take down the ruthless Armando Armas, the vicious leader of a Miami drug cartel.",
                "2020-01-15",
                "en",
                "/y95lQLnuNKdPAzw9F9Ab8kJ80c3.jpg",
                "/upUy2QhMZEmtypPW3PdieKLAHxh.jpg",
                7.2,
                null
        ));
        movies.add(new Movie(
                181812,
                "Star Wars : The Rise of Skywalker",
                "The surviving Resistance faces the First Order once again as the journey of Rey, Finn and Poe Dameron continues. With the power and knowledge of generations behind them, the final battle begins.",
                "2019-12-18",
                "en",
                "/db32LaOibwEliAmSL2jjDF6oDdj.jpg",
                "/jOzrELAzFxtMx2I4uDGHOotdfsS.jpg",
                6.5,
                null
        ));
        movies.add(new Movie(
                495764,
                "Birds of Prey (and the Fantabulous Emancipation of One Harley Quinn)",
                "Harley Quinn joins forces with a singer, an assassin and a police detective to help a young girl who had a hit placed on her after she stole a rare diamond from a crime lord.",
                "2020-02-05",
                "en",
                "/h4VB6m0RwcicVEZvzftYZyKXs6K.jpg",
                "/uozb2VeD87YmhoUP1RrGWfzuCrr.jpg",
                7.2,
                null
        ));
        movies.add(new Movie(
                338762,
                "Bloodshot",
                "After he and his wife are murdered, marine Ray Garrison is resurrected by a team of scientists. Enhanced with nanotechnology, he becomes a superhuman, biotech killing machine—'Bloodshot'. As Ray first trains with fellow super-soldiers, he cannot recall anything from his former life. But when his memories flood back and he remembers the man that killed both him and his wife, he breaks out of the facility to get revenge, only to discover that there's more to the conspiracy than he thought.",
                "2020-03-05",
                "en",
                "/8WUVHemHFH2ZIP6NWkwlHWsyrEL.jpg",
                "/ocUrMYbdjknu2TwzMHKT9PBBQRw.jpg",
                7.2,
                null
        ));
        movies.add(new Movie(
                512200,
                "Jumanji: The Next Level",
                "As the gang return to Jumanji to rescue one of their own, they discover that nothing is as they expect. The players will have to brave parts unknown and unexplored in order to escape the world’s most dangerous game.",
                "2019-12-04",
                "en",
                "/bB42KDdfWkOvmzmYkmK58ZlCa9P.jpg",
                "/oLma4sWjqlXVr0E3jpaXQCytuG9.jpg",
                6.9,
                null
        ));
        movies.add(new Movie(
                668203,
                "Scary Movie 6",
                "[RUMORED]  The sixth and final installment of the Scary Movie franchise that ignores the fifth film. A parody of Scream 4 and various other horror movies, sequels and reboots that were released between the late 2010's and 2020. Takes place 15 years after the fourth film.",
                "2021-04-02",
                "en",
                "/mWOkjqqzWiaFC65i2nFuMzM9jne.jpg",
                "/wuJpiGNGv7wLg52ONizLrOugYp9.jpg",
                0,
                null
        ));

        return movies;
    }

    public static List<TV> generateDummyTV() {
        ArrayList<TV> tv = new ArrayList<>();

        tv.add(new TV(
                93533,
                "Thieves of the Wood",
                "2020-01-02",
                "Charismatic highwayman Jan de Lichte leads the oppressed and downtrodden in a revolt against the corrupt aristocracy of 18th-century Belgium.",
                "nl",
                "/jQNOzoiaIQWxJAx8OUighnvnhRA.jpg",
                "/gVVaukIifGJD78llZKgyT5FQbAe.jpg",
                5.9,
                null
        ));
        tv.add(new TV(
                2734,
                "Law & Order: Special Victims Unit",
                "1999-09-20",
                "In the criminal justice system, sexually-based offenses are considered especially heinous. In New York City, the dedicated detectives who investigate these vicious felonies are members of an elite squad known as the Special Victims Unit. These are their stories.",
                "en",
                "/6t6r1VGQTTQecN4V0sZeqsmdU9g.jpg",
                "/cD9PxbrdWYgL7MUpD9eOYuiSe2P.jpg",
                6.8,
                null
        ));
        tv.add(new TV(
                71446,
                "Money Heist",
                "2017-05-02",
                "To carry out the biggest heist in history, a mysterious man called The Professor recruits a band of eight robbers who have a single characteristic: none of them has anything to lose. Five months of seclusion - memorizing every step, every detail, every probability - culminate in eleven days locked up in the National Coinage and Stamp Factory of Spain, surrounded by police forces and with dozens of hostages in their power, to find out whether their suicide wager will lead to everything or nothing.",
                "es",
                "/MoEKaPFHABtA1xKoOteirGaHl1.jpg",
                "/xGexTKCJDkl12dTW4YCBDXWb1AD.jpg",
                8.4,
                null
        ));
        tv.add(new TV(
                60735,
                "The Flash",
                "2014-10-07",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "en",
                "/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg",
                "/6ZdQTBy20HzWudZthAV7NkZWfIb.jpg",
                7.2,
                null
        ));
        tv.add(new TV(
                63247,
                "Westworld",
                "2016-10-02",
                "A dark odyssey about the dawn of artificial consciousness and the evolution of sin. Set at the intersection of the near future and the reimagined past, it explores a world in which every human appetite, no matter how noble or depraved, can be indulged.",
                "en",
                "/y55oBgf6bVMI7sFNXwJDrSIxPQt.jpg",
                "/yGNnjoIGOdQy3douq60tULY8teK.jpg",
                8.2,
                null
        ));
        tv.add(new TV(
                92779,
                "My Girlfriend is an Alien",
                "2019-08-19",
                "The alien girl Chai Xiaoqi tells the story of Fang Xiaoqi, the overbearing president of the alien girl who died from the \"Cape Town Planet\", who was suffering from the \"rainy weather heterosexual amnesia\". A high-energy hilarious and romantic cross-star love story. The female host Chai Xiaoqi is not only an alien, but also a true-handed witch. Once she inhales the hormones emitted by the males in the earth, she will fall into the \"flowery state\" and suffer from various diseases. The fun and ridiculously ridiculous romance will restore the singularity of the girl in the perfection of the girl. In order to survive on the human earth, Chai Xiaoqi will use his various super powers to solve one accident after another, like a roller coaster. The ups and downs will make the audience hooked. The male lord is cold and is an alternative overbearing president. When it rains, he will forget the opposite sex that appears around him. For this reason, he and the female host will launch various \"fighting and fighting\" laughter dramas. The experience of high sweetness and romance is expected to be Strongly slammed the girl's heart when it was broadcast.",
                "zh",
                "/5e2owvs9TWVsuIacTFxJGPp6KVW.jpg",
                "/kCl7piWv3pypgYfyLFi7ZgFGlYV.jpg",
                7.8,
                null
        ));
        tv.add(new TV(
                456,
                "The Simpsons",
                "1989-12-17",
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                "en",
                "/qcr9bBY6MVeLzriKCmJOv1562uY.jpg",
                "/5zS9trn5k6T6Oew85ZIEKUfRo91.jpg",
                7.4,
                null
        ));
        tv.add(new TV(
                2410,
                "Diff'rent Strokes",
                "1978-11-03",
                "The series stars Gary Coleman and Todd Bridges as Arnold and Willis Jackson, two African American boys from Harlem who are taken in by a rich white Park Avenue businessman named Phillip Drummond and his daughter Kimberly, for whom their deceased mother previously worked. During the first season and first half of the second season, Charlotte Rae also starred as the Drummonds' housekeeper, Mrs. Garrett.",
                "en",
                "/3MNIPC2v9a43IJCwEYiiY327rKH.jpg",
                "/xKDwo1JBaGs6v2fAd7kQVbakbuA.jpg",
                6.6,
                null
        ));
        tv.add(new TV(
                62455,
                "Locked Up",
                "2015-04-20",
                "Set up to take the blame for corporate fraud, young Macarena Ferreiro is locked up in a high-security women's prison surrounded by tough, ruthless criminals in this tense, provocative Spanish thriller.",
                "es",
                "/7mfPWKrNInkTbjVwp0EkaFYRHqD.jpg",
                "/ck4WJ3dLXzUd3cNgujxuuk0QvlW.jpg",
                8,
                null
        ));
        tv.add(new TV(
                61689,
                "The Red Tent",
                "2014-12-07",
                "Her name is Dinah. In the Bible her life is only hinted at during a brief and violent detour within the more familiar chapters about her father, Jacob, and his dozen sons in the Book of Genesis. Told through Dinah's eloquent voice, this sweeping miniseries reveals the traditions and turmoil of ancient womanhood. Dinah's tale begins with the story of her mothers: Leah, Rachel, Zilpah, and Bilhah, the four wives of Jacob. They love Dinah and give her gifts that are to sustain her through a hard-working youth, a calling to midwifery, and a new home in a foreign land. Dinah tells us of the world of the red tent, the place where women were sequestered during their cycles of birthing, menses, and illness; of her initiations into the religious and sexual practices of her tribe; of Jacob's courtship with his four wives; of the mystery and wonder of caravans, farmers, shepherds, and slaves; of love and death in the city of Shechem; of her half-brother Joseph's rise in Egypt, and of course her marriage to Shechem and it's bloody consequences.",
                "en",
                "/hSttE4mnZdmANv6snbK2RYncbbs.jpg",
                "/iVAdLIbHIudPHPqzFB2nAl8pKr4.jpg",
                7.2,
                null
        ));

        return tv;
    }
}
