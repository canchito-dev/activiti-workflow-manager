/**
 * This content is released under the MIT License (MIT)
 *
 * Copyright (c) 2017, canchito-dev
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * 
 * @author 		José Carlos Mendoza Prego
 * @copyright	Copyright (c) 2017, canchito-dev (http://www.canchito-dev.com)
 * @license		http://opensource.org/licenses/MIT	MIT License
 * @link		https://github.com/canchito-dev/activiti-workflow-manager
 **/
package com.canchitodev.awm.activiti.tasks.runnable;

import org.springframework.stereotype.Service;

import com.canchitodev.awm.activiti.tasks.TaskRunnable;
import com.canchitodev.awm.activiti.tasks.domain.GenericTaskEntity;
import com.canchitodev.awm.utils.enums.BehaviorTaskType;

@Service
public class TaskRunnableFactory {

	public TaskRunnable getRunnable(GenericTaskEntity task) {
		if(task == null)
			return null;
		switch(BehaviorTaskType.get(task.getType())) {
			case MOVE:
				return new MoveTaskRunnable(task);
			case COPY:
				return new CopyTaskRunnable(task);
			case TASK1:
				return new Task1Runnable(task);
			case TASK2:
				return new Task2Runnable(task);
			default:
				return null;
		}
	}
}
