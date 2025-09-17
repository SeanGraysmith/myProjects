# Programmer:   REDACTED, but this project was the work of myself and a partner. 
# Course:       REDACTED
# Semester:     Spring 2024
# Assignment:   Data Analysis Project
# File Name:    data_analysis_project
# Description: This project takes an input CSV file (must be in a certain format) and uses it to create dataframes which then are used to create visuals such as graphs. 
import seaborn as sns
import matplotlib.pyplot as plt
import numpy as np
import os
import pandas as pd
import matplotlib.ticker as tkr

# Dynamic location reading
dirname = os.path.dirname(__file__)
absdir = os.path.join(dirname, r'arbitraryFileName.csv')
df = pd.read_csv(absdir)

# Cleaning data imported from csv
# ---------------------------------------------

# Formatting Dataframe
df.rename(columns = {'q1':'age', 'q2':'sex', 'q3':'grade', 'q4':'race1', 'q5':'race2', 'q6':'height', 'q7':'weight', 'q41':'alcohol', 'q66':'desc_weight', 'q77':'phys_act','q85':'mental_health', 'q86':'sleep'}, inplace=True)

# Remove NA values and other unrelated demographic data
# q5 was a bit more annoying to read as it accepts multiple answers so it is excluded for the moment, q3 is removed because
# it is similar to age and age is more exact
df = df.dropna() # removes NA values from dataframe
df = df.drop(columns=['grade','race1','race2'])

# Convert meters to feet in height (q6)
for value in df.index:
    df.loc[value, 'height'] = round(df.loc[value, 'height'] * 3.281, 2)
    
# Plotting Functions
# -------------------------------------------
# NOTE: The functions were written to take the entire dataframe as an argument
#   This makes them more compartmentalized IMO

# Heatmap
def heatmap(dataframe):
    # Reset matplotlib values to defaults (so plot settings don't carry over)
    plt.rcParams.update(plt.rcParamsDefault)
    
    sns.set(font_scale=2.0)
    plt.figure(figsize=(20,10))
    hmp = sns.heatmap(dataframe.corr(), annot=True, cmap='RdPu', linewidths=0.5,vmin=-1,vmax=1,fmt='.3f')
    hmp.set_title('Correlation Between Various Survey Questions and Mental Health')
    plt.tight_layout() 

    # Show plot
    plt.show()
# Pie Charts
def piecharts_mh(dataframe):
    # Computing data to use in chart 1 and chart 2
    m_mh_never, m_mh_bad, f_mh_never, f_mh_bad = 0,0,0,0
    
    
    for value in dataframe.index:
        if dataframe.loc[value, 'sex'] == 1:
            if dataframe.loc[value, 'mental_health'] == 1:
                f_mh_never += 1
            else:
                f_mh_bad += 1 
        else:
            if dataframe.loc[value, 'mental_health'] == 1:
                m_mh_never += 1
            else:
                m_mh_bad += 1 
        
    
    # Reset matplotlib values to defaults (so plot settings don't carry over)
    plt.rcParams.update(plt.rcParamsDefault)
    
    # Create pie charts
    fig, (ax1, ax2) = plt.subplots(1,2)
    fig.suptitle('Male vs. Female Negative Mental Health', fontsize=16)
    
    # Pie chart number 1 creation
    pie1_labels = ['No negative mental health', 'Negative mental health']
    pie1_data = np.array([m_mh_never,m_mh_bad])
    pie1_colors = ['#89ABE3','#EA738D']
    pie1_explode = [0.1,0]
    ax1.pie(pie1_data, labels=pie1_labels, startangle=45, colors=pie1_colors, explode=pie1_explode,shadow=True,autopct='%1.1f%%', textprops={'fontsize':10})
    ax1.set_title('Male',fontsize=20)
    
    
    # Pie chart number 2 creation
    pie2_labels = ['No negative mental health', 'Negative mental health']
    pie2_data = np.array([f_mh_never, f_mh_bad])
    pie2_colors = ['#89ABE3','#EA738D']
    pie2_explode = [0.1,0]
    ax2.pie(pie2_data, labels=pie2_labels, startangle=90, colors=pie2_colors, explode=pie2_explode, shadow=True,autopct='%1.1f%%', textprops={'fontsize':9})
    ax2.set_title('Female', fontsize=20)
    
    # Show plot
    plt.show()

def piecharts_sleep(dataframe):
    # Generating data
    # First assignment statement is variables for males, and hours of sleep
    # Second assignment is variables for females, and hours of sleep
    four_less_m, five_h_m, six_h_m, seven_h_m, eight_h_m, nine_h_m, ten_more_m = 0, 0, 0, 0, 0, 0, 0
    four_less_f, five_h_f, six_h_f, seven_h_f, eight_h_f, nine_h_f, ten_more_f = 0, 0, 0, 0, 0, 0, 0
    
    for value in dataframe.index:
        if dataframe.loc[value, 'sex'] == 1:
            if dataframe.loc[value, 'sleep'] == 1:
                four_less_f += 1
            elif dataframe.loc[value, 'sleep'] == 2:
                five_h_f += 1
            elif dataframe.loc[value, 'sleep'] == 3:
                six_h_f += 1
            elif dataframe.loc[value, 'sleep'] == 4:
                seven_h_f += 1 
            elif dataframe.loc[value, 'sleep'] == 5:
                eight_h_f += 1 
            elif dataframe.loc[value, 'sleep'] == 6:
                nine_h_f += 1
            elif dataframe.loc[value, 'sleep'] == 7:
                ten_more_f
        else:
            if dataframe.loc[value, 'sleep'] == 1:
                four_less_m += 1
            elif dataframe.loc[value, 'sleep'] == 2:
                five_h_m += 1
            elif dataframe.loc[value, 'sleep'] == 3:
                six_h_m += 1
            elif dataframe.loc[value, 'sleep'] == 4:
                seven_h_m += 1 
            elif dataframe.loc[value, 'sleep'] == 5:
                eight_h_m += 1 
            elif dataframe.loc[value, 'sleep'] == 6:
                nine_h_m += 1
            elif dataframe.loc[value, 'sleep'] == 7:
                ten_more_m
    
    # Reset matplotlib values to defaults (so plot settings don't carry over)
    plt.rcParams.update(plt.rcParamsDefault)
    
    fig, (ax1, ax2) = plt.subplots(1,2)
    fig.suptitle('Hours of Sleep on School Nights', fontsize=16)
    
    # Pie chart number 1 creation
    pie3_labels = ['Four or less', 'five hours', 'six_hours', 'seven_hours', 'eight_hours', 'nine_hours']
    pie3_data = np.array([four_less_m, five_h_m, six_h_m, seven_h_m, eight_h_m, nine_h_m])
    pie3_colors = ['#89ABE3','#EA738D']
    pie3_explode = [0,0,0,0,0,0]
    ax1.pie(pie3_data, labels=pie3_labels, startangle=25, colors=pie3_colors, explode=pie3_explode,shadow=True,autopct='%1.1f%%', textprops={'fontsize':9,'color':'#0000CD'})
    ax1.set_title('Male',fontsize=15, color='#0000CD')
    
    
    # Pie chart number 2 creation
    pie4_labels = ['Four or less', 'five hours', 'six_hours', 'seven_hours', 'eight_hours', 'nine_hours']
    pie4_data = np.array([four_less_f, five_h_f, six_h_f, seven_h_f, eight_h_f, nine_h_f])
    pie4_colors = ['#89ABE3','#EA738D']
    pie4_explode = [0,0,0,0,0,0]
    ax2.pie(pie4_data, labels=pie4_labels, startangle=0, colors=pie4_colors, explode=pie4_explode, shadow=True,autopct='%1.1f%%', textprops={'fontsize':9,'color':'#AA336A'})
    ax2.set_title('Female', fontsize=15, color='#AA336A')
    
    # Show plot
    plt.show()
# Bar chart (mental health by age)
def bar_mh_age(dataframe):
    # Reset matplotlib values to defaults (so plot settings don't carry over)
    plt.rcParams.update(plt.rcParamsDefault)
    
    # Generate data for use in the chart, each age range is assigned a variable. 
    a_tw_younger, a_thirteen, a_fourteen, a_fifteen, a_sixteen, a_seventeen, a_et_older = 0,0,0,0,0,0,0
    for value in dataframe.index:
        if (dataframe.loc[value,'age'] == 1) and (dataframe.loc[value,'mental_health'] != 1):
            a_tw_younger += 1
        elif (dataframe.loc[value,'age'] == 2) and (dataframe.loc[value,'mental_health'] != 1):
            a_thirteen += 1
        elif (dataframe.loc[value,'age'] == 3) and (dataframe.loc[value,'mental_health'] != 1):
            a_fourteen += 1
        elif (dataframe.loc[value,'age'] == 4) and (dataframe.loc[value,'mental_health'] != 1):
            a_fifteen += 1
        elif (dataframe.loc[value,'age'] == 5) and (dataframe.loc[value,'mental_health'] != 1):
            a_sixteen += 1
        elif (dataframe.loc[value,'age'] == 6) and (dataframe.loc[value,'mental_health'] != 1):
            a_seventeen += 1
        elif (dataframe.loc[value,'age'] == 7) and (dataframe.loc[value,'mental_health'] != 1):
            a_et_older += 1

    hist_data= [a_tw_younger,a_thirteen,a_fourteen,a_fifteen,a_sixteen,a_seventeen,a_et_older]
    order = ['Twelve & Under','Thirteen', 'Fourteen', 'Fifteen', 'Sixteen', 'Seventeen', 'Eighteen+']
    
    plt.figure(figsize=(15,5))
    plt.bar(order,hist_data, width=0.8, color='#EA738D')
    plt.title('Reported Cases of Bad Mental Health by Age')
    plt.xlabel('Age')
    plt.ylabel('Count')
    
    # Show plot
    plt.show()

# Histogram (mental health related)
def histogram_mh(dataframe):
    # Separate mental health data into two different variables; male and female
    female = []
    male = []
    for value in dataframe.index:
        if dataframe.loc[value,'sex'] == 1:
            female.append(dataframe.loc[value,'mental_health'])
        else:
            male.append(dataframe.loc[value, 'mental_health'])
    
    # Reset matplotlib values to defaults (so plot settings don't carry over)
    plt.rcParams.update(plt.rcParamsDefault)
    
    fig, ax = plt.subplots()
    
    ax.xaxis.set_ticks_position('bottom')
    ax.tick_params(which='major', width=1.00, length=5)
    ax.set_xlim(1, 5)
    ax.xaxis.set_major_locator(tkr.FixedLocator([ 1, 2, 3, 4, 5]))
    
    plt.hist([male, female], bins=5, stacked=True, color=['#89ABE3', '#EA738D'], edgecolor='black',align='mid')
    ax.set_xticklabels(['Never','Rarely','Sometimes','Mostly','Always'],fontsize=12, horizontalalignment='center')
    
    # labels and title and legend
    plt.xlabel('Survey Answers')
    plt.ylabel('Frequency')
    plt.title('Male vs. Female Frequency of Bad Mental Health')
    plt.legend(['Male', 'Female'])
    sns.set(font_scale=1.0)
    
     
    # Show plot
    plt.show()


# User Interface
# ---------------------------------------------

print('\nThis program will compute data from the CDC about mental health and display it in various forms.')
while True:
    print('\n1. Pie Chart Mental Health\n2. Pie Chart Sleep\n3. Histogram\n4. Bar Chart\n5. Heatmap')
    while True:
        graph_type = (input('Which graph would you like to see? '))
        try:
            graph_type = int(graph_type)
        except ValueError:
            print('Invalid input, the value must be a number.')
            continue
        if (graph_type >= 1) and (graph_type <= 5):
            break
        else:
            print('Invalid input, please try again within the range of (1-5).')
    if (graph_type == 1):
        piecharts_mh(df)
        print('------------------------\nThese pie charts display the cases of negative mental health by gender.')
    elif (graph_type == 2):
        piecharts_sleep(df)
        print('------------------------\nThis set of pie charts displays distribution of sleep patterns between male and females.')
        print('While this is not directly related to mental health, sleep did have a small correlation to it.')
    elif (graph_type == 3):
        histogram_mh(df)
        print('------------------------\nThe histogram compares male vs. female mental health as described by 5 different survey questions.')
    elif (graph_type == 4):
        bar_mh_age(df)
        print('------------------------\nThe bar chart shows the distribution of negative mental health over different ages.')
    else:
        heatmap(df)
        print('------------------------\nThe heatmap shows correlation between different variables and mental health.')
        
    # Allow user to continue or end. 
    again = input('------------------------------\nWould you like to see another graph? (y/n) ').lower()
    if (again == 'y'):
        continue
    elif (again == 'n'):
        print('----------\nThank you for using our program!')
        break 
    else:
        print('Invalid input, exiting...')

        break
