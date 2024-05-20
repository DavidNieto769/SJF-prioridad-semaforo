package Modelo;
import Vista.SemaforoPanel;
import Vista.Window;

import java.awt.*;
import java.lang.Thread;

import static java.lang.Thread.sleep;

public class SJF {

	private Queue<Process> queue;
	private int currentFinalTime;
	private int serialId;
	private SemaforoPanel semaforo;


	public SJF() {
		queue = new Queue<Process>();
		currentFinalTime = 0;
		serialId = 0;
	}

	private int random(int min, int max) {
		return (int) (Math.random() * max + min);
	}

	private void calcuteTime(Process process) {
		process.setStartTime(currentFinalTime);
		process.setFinalTime(process.getBurstTime() + process.getStartTime());
		process.setReturnTime(process.getFinalTime() - process.getArrivalTime());
		process.setWaitTime(process.getReturnTime() - process.getBurstTime());
		currentFinalTime = process.getFinalTime();
	}

	public Object[] getDataProcess(Process process) {
		calcuteTime(process);
		return process.resume();
	}

	public Object[] addProcess() {
		Process process = new Process(serialId + 1, serialId, random(1, 4), random(1, 4));
		queue.add(process);
		serialId++;
		return process.resume();
	}

	public Object[] appendProcess(Process process) {
		queue.add(process);
		return process.resume();
	}

	public Process pollProcess() {
		return queue.poll();
	}

	public void setSemaforo(SemaforoPanel semaforo){
		this.semaforo = semaforo;
	}
	public Process pollProcessByPriority() throws InterruptedException {



		Process data = null;

		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= queue.getSize(); j++) {
				data = queue.getData(j);
				if (data.getPriority() == i) {
					if (data.getArrivalTime() <= currentFinalTime) {

						semaforo.setBackground(Color.red);
						Thread.sleep(1000);
						queue.remove(j);
						semaforo.setBackground(Color.green);


						return data;
					}
				}
			}
		}

		return data;
	}



	public int getSerialId() {
		return serialId;
	}

	public int getCurrentFinalTime() {
		return currentFinalTime;
	}

	public boolean isQueueEmpty() {
		return queue.isEmpty();
	}

	public void finalizeQueue() throws Throwable {
		queue.finalize();
	}
}