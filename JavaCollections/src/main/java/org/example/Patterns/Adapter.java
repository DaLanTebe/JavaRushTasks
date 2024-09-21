package org.example.Patterns;

public class Adapter {
    interface Time {
        int getSeconds();

        int getMinutes();

        int getHours();
    }

    interface TotalTime {
        int getTotalSeconds();
    }

    class TotalTimeAdapter implements Time {
        private TotalTime totalTime;

        public TotalTimeAdapter(TotalTime totalTime) {
            this.totalTime = totalTime;
        }

        public int getSeconds() {
            return totalTime.getTotalSeconds() % 60; //секунды
        }

        public int getMinutes() {
            return (totalTime.getTotalSeconds() % (60 * 60)) / 60; //минуты
        }

        public int getHours() {
            return totalTime.getTotalSeconds() / (60 * 60); //часы
        }
    }
}
