package lab0101;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;
import javax.sound.midi.MidiChannel;

/**
 * Created by David on 12/11/2015.
 */
public class APSynthesizer {//need the use of APSynthesizerRunner to run

    public void play(int[][] song) {
        int len, noteNum, channel, volume, note, play, sleep;

        try {
            Synthesizer synth = MidiSystem.getSynthesizer();
            synth.open();
            MidiChannel[] channels = synth.getChannels();

            // --------------------------------------
            // Play a few notes.
            // The two arguments to the noteOn() method are:
            // "MIDI note number" (pitch of the note),
            // and "velocity" (i.e., volume, or intensity).
            // Each of these arguments is between 0 and 127.
            for (int i = 0; i < song.length; i++) {
                len = song[i].length;
                noteNum = (len - 1) / 4;
                sleep = song[i][0];

                for (int j = 1; j <= noteNum; j++) {
                    channel = song[i][(j * 4) - 2];
                    volume = song[i][(j * 4)];
                    note = song[i][(j * 4) - 1];
                    play = song[i][(j * 4) - 3];

                    if (play == 1) {
                        channels[channel].noteOn(note, volume);
                    } else if (play == 0) {
                        channels[channel].noteOff(note);
                    }
                }
                Thread.sleep(sleep);
            }
            synth.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
