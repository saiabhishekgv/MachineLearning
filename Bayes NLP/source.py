# -*- coding: utf-8 -*-
"""
Created on Mon Jul 03 13:17:06 2017

@author: iLenovo
"""

"""  Maximum likelihood """

sample_memo = '''
Milt, we're gonna need to go ahead and move you downstairs into storage B. We have some new people coming in, and we need all the space we can get. So if you could just go ahead and pack up your stuff and move it down there, that would be terrific, OK?
Oh, and remember: next Friday... is Hawaiian shirt day. So, you know, if you want to, go ahead and wear a Hawaiian shirt and jeans.
Oh, oh, and I almost forgot. Ahh, I'm also gonna need you to go ahead and come in on Sunday, too...
Hello Peter, whats happening? Ummm, I'm gonna need you to go ahead and come in tomorrow. So if you could be here around 9 that would be great, mmmk... oh oh! and I almost forgot ahh, I'm also gonna need you to go ahead and come in on Sunday too, kay. We ahh lost some people this week and ah, we sorta need to play catch up.
'''

corrupted_memo = '''
Yeah, I'm gonna --- you to go ahead --- --- complain about this. Oh, and if you could --- --- and sit at the kids' table, that'd be --- 
'''


#
#   Maximum Likelihood Hypothesis
#
#
#   In this quiz we will find the maximum likelihood word based on the preceding word
#
#   Fill in the NextWordProbability procedure so that it takes in sample text and a word,
#   and returns a dictionary with keys the set of words that come after, whose values are
#   the number of times the key comes after that word.
#   
#   Just use .split() to split the sample_memo text into words separated by spaces.

print 'Given text : ' 
print sample_memo


def NextWordProbability(sampletext,word):
    words_list = sample_memo.strip().split()
    print words_list
    words_to_guess = ["ahead","could"]

    words_list= sampletext.split(' ')
    result = {}
    count = 0
    while (count<len(words_list)) :
        if (words_list[count]==word) and count<len(words_list):
            if result.has_key(words_list[count+1]) :
                result[words_list[count+1]] = result[words_list[count+1]] + 1
            else:
                result[words_list[count+1]] = 1
        count = count + 1
    print result
    return result

print 'max number of times a Word following the string gonna is (key,number of times it repeated):'
NextWordProbability(sample_memo,'gonna')